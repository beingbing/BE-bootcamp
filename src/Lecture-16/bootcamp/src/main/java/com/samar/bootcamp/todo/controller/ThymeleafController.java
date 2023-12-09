package com.samar.bootcamp.todo.controller;

import com.samar.bootcamp.todo.manager.ToDoManager;
import com.samar.bootcamp.todo.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ThymeleafController {

    @Autowired
    private ToDoManager toDoManager;

    @GetMapping
    public String getAllToDoLists(Model model) {
        System.out.println("get all to do lists");
        model.addAttribute("items", toDoManager.getTodoList().getItem());
        model.addAttribute("newItem", new ToDoList.ToDoItem());
        return "index";
    }

    @PostMapping("/")
    public String addItem(@ModelAttribute("newItem") ToDoList.ToDoItem newItem, Model model) {
        if (ObjectUtils.isEmpty(newItem.getContent())) return "index";
        System.out.println("add item: " + newItem);
        toDoManager.addNewTodoItem(newItem);
        model.addAttribute("items", toDoManager.getTodoList().getItem());
        model.addAttribute("newItem", new ToDoList.ToDoItem());
        return "index";
    }
}
