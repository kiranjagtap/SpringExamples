package com.flipkart.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flipkart.model.Todo;
import com.flipkart.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {

		List<Todo> todos = service.retrieveTodos("dummy");
		model.addAttribute("todos", todos);
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage() {
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, Todo todo) {
		System.out.println("--------" + todo.toString());
		service.addTodo((String) model.get("name"), todo.getDesc(), new Date(), todo.isDone());
		// model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}

	// Command bean Todo todo
	/*
	 * @RequestMapping(value = "/add-todo", method = RequestMethod.POST) public
	 * String addTodo(ModelMap model, Todo todo) { service.addTodo((String)
	 * model.get("name"), todo.getDesc(), new Date(), false); model.clear();// to
	 * prevent request parameter "name" to be passed return "redirect:/list-todos";
	 * }
	 */

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos";
	}
}