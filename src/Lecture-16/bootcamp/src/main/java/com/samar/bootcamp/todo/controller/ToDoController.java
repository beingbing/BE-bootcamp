package com.samar.bootcamp.todo.controller;

import com.samar.bootcamp.todo.manager.ToDoManager;
import com.samar.bootcamp.todo.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo/*")
public class ToDoController {

    @Autowired
    private ToDoManager toDoManager;

    @GetMapping
    public ToDoList getAllToDoLists() {
        System.out.println("get all to do lists");
        return toDoManager.getTodoList();
    }

    @GetMapping("/{id}")
    public ToDoList.ToDoItem getToDoItemById(@PathVariable Long id) {
        System.out.println("get to-do with id: " + id);
        return toDoManager.getToDoItemFromList(id);
    }

    @PostMapping
    public ToDoList createToDoList(@RequestBody ToDoList.ToDoItem toDoItem) {
        System.out.println("create a new to-do item: " + toDoItem);
        return toDoManager.addNewTodoItem(toDoItem);
    }

    @PutMapping("/{id}")
    public ToDoList updateToDoList(@PathVariable Long id, @RequestBody ToDoList.ToDoItem updatedToDoItem) {
        System.out.println("update to-do with id: " + id);
        return toDoManager.updateSpecificToDoItem(id, updatedToDoItem);
    }

    @DeleteMapping("/{id}")
    public ToDoList deleteToDoList(@PathVariable Long id) {
        System.out.println("delete to-do with id: " + id);
        return toDoManager.deleteSpecificTodoItem(id);
    }
}
