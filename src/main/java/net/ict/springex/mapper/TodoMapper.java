package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO); //insert 기능 추가
}
