package net.ict.springex.dto;
/* 페이지 처리는 현재 페이지 번호(page), 현재 페이지당 데이터 수(size) 기본적으로 필요
* */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

//dto에 필요한 어노테이션
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;


    @Builder.Default //여기서 빌더 패턴을 통해 인스턴스를 만들 때 특정 필드를 특정 값으로 초기화하고 싶다면 @Builder.Default를 쓰면 된다.
    @Min(value = 1)
    @Positive //양수만 처리
    private int page = 1;

    @Builder.Default //상수처리하겠다 고정값 //롬복에서 page, size의 기본값 처리할때
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip(){
        return (page-1) *10;
    }

    public boolean checkType(String type){
        if(types ==null || type.length()==0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();

        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if (finished){
            builder.append("&finished=on");
        }
        if (types != null && types.length > 0){
            for (int i = 0; i < types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }
        if (keyword != null){
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        if(from != null){
            builder.append("&from=" + from.toString());
        }
        if(to != null){
            builder.append("&to=" + to.toString());
        }

        return builder.toString();

    }
}
