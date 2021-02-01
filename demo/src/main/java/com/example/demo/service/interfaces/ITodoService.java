package com.example.demo.service.interfaces;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.TodoBean;

public interface ITodoService {

	List<TodoBean> retrieveTodos(String name);

	void addTodo(String name, String desc, Date targetDate, boolean isComplete);

	void deleteTodo(Integer id);

	TodoBean retrieveTodo(int id);

	void updateTodo(@Valid TodoBean todoBean);

}