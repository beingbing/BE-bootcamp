package com.samar.bootcamp.todo.manager;

import com.samar.bootcamp.todo.constants.ListConstants;
import com.samar.bootcamp.todo.model.ToDoList;
import com.samar.bootcamp.todo.service.impl.SingleToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToDoManager {
    @Autowired
    private SingleToDoListService singleToDoListService;

    // get all to-dos
    public ToDoList getTodoList() {
        return singleToDoListService.getToDoListById(ListConstants.DEFAULT_LIST_ID);
    }

    // get a specific to-do
    public ToDoList.ToDoItem getToDoItemFromList(Long itemId) {
        return singleToDoListService.getToDoItemFromListById(itemId, ListConstants.DEFAULT_LIST_ID);
    }

    // add a to-do
    public ToDoList addNewTodoItem(ToDoList.ToDoItem newTodoItem) {
        return singleToDoListService.createToDoItemInList(newTodoItem, ListConstants.DEFAULT_LIST_ID);
    }

    // delete a specific to-do
    public ToDoList deleteSpecificTodoItem(Long itemId) {
        return singleToDoListService.deleteToDoItemInList(itemId, ListConstants.DEFAULT_LIST_ID);
    }

    // update a specific to-do
    public ToDoList updateSpecificToDoItem(Long itemId, ToDoList.ToDoItem newTodoItem) {
        return singleToDoListService.updateToDoItemInList(itemId, newTodoItem, ListConstants.DEFAULT_LIST_ID);
    }
}
