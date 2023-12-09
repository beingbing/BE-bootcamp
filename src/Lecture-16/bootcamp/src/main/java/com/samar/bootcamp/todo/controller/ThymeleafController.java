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
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateItem(@ModelAttribute("newItem") ToDoList.ToDoItem newItem, Model model) {
        if (ObjectUtils.isEmpty(newItem.getContent())) return "index";
        System.out.println("update item: " + newItem);
        toDoManager.updateSpecificToDoItem(newItem.getItemId(), newItem);
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String updateItem(@PathVariable Long id, Model model) {
        System.out.println("update item: " + id);
        ToDoList.ToDoItem item = toDoManager.getToDoItemFromList(id);
        item.setIsCompleted(!item.getIsCompleted());
        toDoManager.updateSpecificToDoItem(id, item);
        return "redirect:/";
    }

    /*
    * GET method can directly be called from link-expression
    * but to call a POST method, we will need a <form> tag.
    * Similar to what is done for /toggle
    * */
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id, Model model) {
        System.out.println("delete item: " + id);
        toDoManager.deleteSpecificTodoItem(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        System.out.println("edit item id: " + id);
        ToDoList.ToDoItem item = toDoManager.getToDoItemFromList(id);
        System.out.println("edit item: " + item);
        model.addAttribute("item", item);
        return "update";
    }
}
