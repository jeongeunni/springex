package net.ict.springex.sample;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.PageResponseDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetNow(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder().title("spring test").dueDate(LocalDate.of(2022,11,14)).writer("ict05").build();
        todoMapper.insert(todoVO);
    }

//    @Test
//    public void testSelectALL(){
//        List<TodoVO> voList = todoMapper.selectAll();
//        voList.forEach(vo->log.info(vo));
//    }

    @Test
    public void testDelete(){
        Long tno = 3L;
        todoMapper.delete(tno);
    }
    @Test
    public void testSelectOne(){
       TodoVO vo = todoMapper.selectOne(1L);
        System.out.println(vo);
    }

    @Test
    public void testUpdate(){
        TodoVO todoVO = TodoVO.builder().title("스프링 수정11")
                .tno(1L)
                .dueDate(LocalDate.of(2022,12,12))
                .writer("정은")
                .finished(true)
                .build();
        todoMapper.update(todoVO);
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo->log.info(vo));
    }


}
