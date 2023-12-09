package com.samar.bootcamp.todo.service;

import com.samar.bootcamp.todo.model.ToDoList;

import java.util.List;

public interface ToDoItemRepository {
    List<ToDoList.ToDoItem> getAllToDoItems();

    ToDoList.ToDoItem getToDoItemById(Long id);

    ToDoList.ToDoItem createToDoItem(ToDoList.ToDoItem toDoItem);

    ToDoList.ToDoItem updateToDoItem(Long id, ToDoList.ToDoItem updatedToDoItem);

    void deleteToDoItem(Long id);
}
