package net.ict.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

//객체 자료형은 파라미터로 처리하기 위해서는 반드시 객체로 생성되고 setXXX() 이용해서 처리
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    @NotEmpty //빈문자열 불가
    private String title;
    @Future //과거가 들어오면 안됨
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer; //작성자를 의미

}
