/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.springboot.SpringBootBase.controller;

import com.in28minutes.springboot.SpringBootBase.dao.Todo;
import com.in28minutes.springboot.SpringBootBase.repository.TodoRepository;
import com.in28minutes.springboot.SpringBootBase.service.TodoService;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class TodoController {
    
    @Autowired
    TodoRepository repository;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
        
    @GetMapping("/list-todos")
    public String showTodo(ModelMap model){
        String username = getLoggedInName(model);
       model.put("todos", repository.findByUser(username));
        return "list-todos";
    }

    private String getLoggedInName(ModelMap model) {
        Collection<Object> values = model.values();
        return (String)model.get("user");
    }
 
    @GetMapping("/add-todos")
    public String showAddTodo(ModelMap model, @ModelAttribute("todo") Todo todo){     
        return "add-todo";
    }
    
    @PostMapping("/add-todos")
    public String addTodo(ModelMap model,@Valid @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors())
            return "add-todo";
        
        todo.setUser(getLoggedInName(model));
        repository.save(todo);
        return "redirect:/list-todos";
    }
    
    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        repository.deleteById(id);
        return "redirect:/list-todos";
    }
    
    @GetMapping("/update-todo")
    public String updateTodo(ModelMap model, @RequestParam int id){
        Todo todo = repository.getOne(id);
        model.put("todo", todo);
        return "add-todo";
    }    
    
    @PostMapping("/update-todo")
    public String updateTodoPost(ModelMap model,@Valid @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors())
            return "add-todo";
        
        todo.setUser(getLoggedInName(model));
        repository.save(todo);
        return "redirect:/list-todos";
    }
}
