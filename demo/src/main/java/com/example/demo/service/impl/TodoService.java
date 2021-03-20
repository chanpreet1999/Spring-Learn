package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.demo.model.TodoBean;
import com.example.demo.service.interfaces.ITodoService;

@Service
public class TodoService implements ITodoService {

	private static List<TodoBean> todoList = new ArrayList<>();
	private static int id = 3;
	
	static {
		todoList.add( new TodoBean(1, "chanpreet", "finish 10 vids", new Date(),  true) );
		todoList.add( new TodoBean(2, "manan", "CFA", new Date(),  false) );
		todoList.add( new TodoBean(3, "chan", "Learn Spring", new Date(),  false) );
	}
	
	@Override
	public List<TodoBean> retrieveTodos(String name)
	{
		List<TodoBean> filteredTodos = new ArrayList<>();
		for(TodoBean todo : todoList)
		{
			if( name.equals( todo.getName() ) )
			{
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isComplete )
	{
		todoList.add(new TodoBean(++id, name, desc, targetDate, isComplete));
	}
	
	@Override
	public void deleteTodo( Integer id )
	{
		Iterator<TodoBean> iterator = todoList.iterator();
		
		while( iterator.hasNext() )
		{
			TodoBean todo  = iterator.next();
			if( id.equals(todo.getId()) )
			{
				iterator.remove();
			}
		}
		
	}

	@Override
	public TodoBean retrieveTodo(int id) {
		
		for(TodoBean todo : todoList) {
			if( todo.getId() == id ) {
				return todo;
			}
		}
		return null;
	}

	@Override
	public void updateTodo(@Valid TodoBean todoBean) {
		todoList.remove(todoBean);
		todoList.add(todoBean);
		
	}
}
