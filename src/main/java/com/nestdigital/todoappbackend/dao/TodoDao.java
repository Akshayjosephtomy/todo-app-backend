package com.nestdigital.todoappbackend.dao;

import com.nestdigital.todoappbackend.model.TodoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TodoDao extends CrudRepository<TodoModel,Integer> {

    @Query(value = "SELECT `id`, `end_date`, `start_date`, `todo`, `userid` FROM `todos` WHERE `userid`= :userid",nativeQuery = true)
    List<Map<String,String>>myTodos(Integer userid);

}
