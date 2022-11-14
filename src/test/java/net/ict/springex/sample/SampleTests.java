package net.ict.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class) //스프링 클래스의 확장 //스프링 클래스를 테스트하는 설정//스프링의 빈을 테스트하겠다
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml") //root-context.xml에 들어있는 빈의 환경 불러오겠다. appctx역할
public class SampleTests {

}