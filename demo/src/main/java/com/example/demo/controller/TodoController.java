package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.TodoBean;
import com.example.demo.service.interfaces.ITodoService;

@Controller
public class TodoController {

	@Autowired
	ITodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/show-todos-list")
	public String retirveTodos(ModelMap modelMap)
	{
		String name = getLoggedInUsername(modelMap);
		modelMap.put("todos", service.retrieveTodos(name));
		return "todos-list";
	}

	private String getLoggedInUsername(ModelMap modelMap) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return ((UserDetails)principal).getUsername();
		
		return principal.toString();
		
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap)
	{
		modelMap.put("todoBean", new TodoBean(0, getLoggedInUsername(modelMap), "Desc", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodoToList(ModelMap modelMap, @Valid TodoBean todoBean, BindingResult result)
	{
		if(result.hasErrors()) {
			return "todo";
		}
		
		service.addTodo(getLoggedInUsername(modelMap), todoBean.getDesc(), todoBean.getTargetDate(), false);
		return "redirect:/show-todos-list";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam Integer id)
	{
		service.deleteTodo(id);
		return "redirect:/show-todos-list";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String gotoUpdateTodo(ModelMap modelMap, @RequestParam int id)
	{
		modelMap.put("todoBean", service.retrieveTodo(id));
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap modelMap, @Valid TodoBean todoBean, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		
		String name = getLoggedInUsername(modelMap);
		todoBean.setName( name );
		service.updateTodo(todoBean);
		return "redirect:/show-todos-list";
	}
}
