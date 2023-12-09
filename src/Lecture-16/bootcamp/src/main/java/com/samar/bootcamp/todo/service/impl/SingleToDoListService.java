package com.samar.bootcamp.todo.service.impl;

import com.samar.bootcamp.todo.model.ToDoList;
import com.samar.bootcamp.todo.service.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleToDoListService implements ToDoListRepository {

    private final ToDoList toDoList;

    private final ToDoItemListService toDoItemListService;

    public SingleToDoListService(@Autowired ToDoItemListService toDoItemService) {
        this.toDoList = new ToDoList(1L, 0L);
        this.toDoList.setItem(toDoItemService.getAllToDoItems());
        this.toDoItemListService = toDoItemService;
    }

    @Override
    public ToDoList getToDoListById(Long id) {
        return toDoList;
    }

    @Override
    public ToDoList.ToDoItem getToDoItemFromListById(Long itemId, Long listId) {
        return toDoItemListService.getToDoItemById(itemId);
    }

    @Override
    public ToDoList createToDoItemInList(ToDoList.ToDoItem toDoItem, Long listId) {
        this.toDoList.setTodoCount(this.toDoList.getTodoCount() + 1);
        toDoItem.setItemId(this.toDoList.getTodoCount());
        toDoItem.setIsCompleted(false);
        System.out.println("In list: " + listId + " new to-do item: " + toDoItem);
        toDoItemListService.createToDoItem(toDoItem);
        System.out.println("new list: " + this.toDoList);
        return toDoList;
    }

    @Override
    public ToDoList updateToDoItemInList(Long itemId, ToDoList.ToDoItem updatedToDoItem, Long listId) {
        toDoItemListService.updateToDoItem(itemId, updatedToDoItem);
        return toDoList;
    }

    @Override
    public ToDoList deleteToDoItemInList(Long itemId, Long listId) {
        toDoItemListService.deleteToDoItem(itemId);
        return toDoList;
    }
}
