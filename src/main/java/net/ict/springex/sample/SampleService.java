package net.ict.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService { //서비스 객체는 기능 제공
    //@RequiredArgsConstructor 스프링 3 이후 생성자 주입방식 -> setter 쓰지않는다.

    @Qualifier("normal") //객체의 이름을 지정해서 특정 이름을 주입받음 //lombok 어노테이션, 스프링 어노테이션 함께 쓰기 위해서 lombok.config설정해줘야한다.
    @Autowired
    private final SampleDAO sampleDAO;
}
