package net.ict.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()") //매퍼 인터페이스 //root-context에 빈으로 등록해줘야 사용가능
    String getTime();

    //데이터베이스의 현재 시간을 제공할 수 있는 어노테이션
    //세미콜론 없으니 조심
}
