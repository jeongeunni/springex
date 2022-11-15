package net.ict.springex.service;

import net.ict.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService { //어떤 글을 등록하는 서비스를 제공하겠다.
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    void remove(Long tno);
    TodoDTO getOne(Long tno);
    void modify(TodoDTO todoDTO);
}
