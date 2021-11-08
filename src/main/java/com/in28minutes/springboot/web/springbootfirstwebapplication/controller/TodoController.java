package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

//Login using /login route
@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodoList(ModelMap model) {
        String name = (String)model.get("name");
        model.put("todos", todoService.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(55, (String) model.get("name"), "Empty", new Date(), false));
        return "todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, Todo todo) {
        todoService.addTodo((String)model.get("name"), todo.getDesc(), todo.getTargetDate(), todo.isDone());
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

}
