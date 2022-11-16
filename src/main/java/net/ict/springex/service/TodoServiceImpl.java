package net.ict.springex.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.PageResponseDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//데이터베이스를 처리하는 TodoMapper와 DTO 와 VO 변환을 처리하는 ModelMapper주입
@Service
@Log4j2
//의존성 주입이 필요한 객체 타입을 final로 고정하고 생성자 @RequiredArgsConstructor 를 이용하여 생성자를 생성하는 방식 사용
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{ //todoService 구현체
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO){
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);

    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());
        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

//    @Override
//    public List<TodoDTO> getAll() {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()  //stream: 빌더와 비슷한 역할
//                .map(vo -> modelMapper.map(vo,TodoDTO.class))   //내가 원하는 todoVo는 modelmapper 를 통해 dto로 바뀜
//                .collect(Collectors.toList()); //vo의 행들을 collect를 통해서 리스트를 하나의 묶음체(테이블)로 만들어줌
//        return dtoList;
//
//        /*List<TodoVO>를 List<TodoDTO>로 변환하는 작업을 stream을 이용하여
//        * 각 TodoVo는 map() 을 통해 TodoDTO로 바꾸고 collect()을 이용하여 List<TodoDTO>로 묶어준다.
//        */
//    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO,TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        todoMapper.update(todoVO);
    }


}
