package com.samar.bootcamp.todo.service;

import com.samar.bootcamp.todo.model.ToDoList;

import java.util.List;

public interface ToDoListRepository {

//    List<ToDoList> getAllToDoLists();

    ToDoList getToDoListById(Long listId);

    ToDoList.ToDoItem getToDoItemFromListById(Long itemId, Long listId);

    ToDoList createToDoItemInList(ToDoList.ToDoItem toDoItem, Long listId);

//    ToDoList createToDoItemInNewList(ToDoList.ToDoItem toDoItem);

    ToDoList updateToDoItemInList(Long itemId, ToDoList.ToDoItem updatedToDoItem, Long listId);

    ToDoList deleteToDoItemInList(Long itemId, Long listId);

//    void deleteToDoList(Long listId);
}
