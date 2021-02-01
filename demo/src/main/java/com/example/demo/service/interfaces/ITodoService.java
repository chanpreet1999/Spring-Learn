package com.example.demo.service.interfaces;

import java.util.Date;
import java.util.List;

import com.example.demo.model.TodoBean;

public interface ITodoService {

	List<TodoBean> retrieveTodos(String name);

	void addTodo(String name, String desc, Date targetDate, boolean isComplete);

	void deleteTodo(Integer id);

}