package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.interfaces.ITodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	ITodoService service;

	@RequestMapping(value = "/show-todos-list")
	public String retirveTodos(ModelMap modelMap)
	{
		String name = (String)modelMap.get("name");
		modelMap.put("todos", service.retrieveTodos(name));
		return "todos-list";
	}
	
	@RequestMapping(value="/todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap)
	{
		return "todo";
	}
	
	@RequestMapping(value="/todo", method = RequestMethod.POST)
	public String addTodoToList(ModelMap modelMap, @RequestParam String desc)
	{
		service.addTodo((String)modelMap.get("name"), desc, new Date(), false);
		return "redirect:/show-todos-list";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam Integer id)
	{
		service.deleteTodo(id);
		return "redirect:/show-todos-list";
	}
}