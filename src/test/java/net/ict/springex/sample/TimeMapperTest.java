package net.ict.springex.sample;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.mapper.TimeMapper;
import net.ict.springex.mapper.TimeMapper2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTest {

//    @Autowired(required = false) //해당객체를 주입하지 않더라도 예외발생하지 않음
//    private TimeMapper timeMapper;
//    @Test
//    public void testGetTime(){
//        log.info(timeMapper.getTime());
//
//    }

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;
    @Test
    public void testGetNow(){
        log.info(timeMapper2.getNow());
    }

}
