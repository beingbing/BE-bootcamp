package com.samar.bootcamp.todo.service.impl;

import com.samar.bootcamp.todo.model.ToDoList;
import com.samar.bootcamp.todo.service.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemListService implements ToDoItemRepository {
    private List<ToDoList.ToDoItem> toDoItemList;

    @Autowired
    public ToDoItemListService(List<ToDoList.ToDoItem> toDoItemList) {
        this.toDoItemList = toDoItemList;
    }

    @Override
    public List<ToDoList.ToDoItem> getAllToDoItems() {
        return toDoItemList;
    }

    @Override
    public ToDoList.ToDoItem getToDoItemById(Long id) {
        Optional<ToDoList.ToDoItem> foundItem = toDoItemList.stream()
                .filter(item -> item.getItemId().equals(id))
                .findFirst();
        return foundItem.orElse(null);
    }

    @Override
    public ToDoList.ToDoItem createToDoItem(ToDoList.ToDoItem toDoItem) {
        toDoItemList.add(toDoItem);
        return toDoItem;
    }

    @Override
    public ToDoList.ToDoItem updateToDoItem(Long id, ToDoList.ToDoItem updatedToDoItem) {
        Optional<ToDoList.ToDoItem> existingItem = toDoItemList.stream()
                .filter(item -> item.getItemId().equals(id))
                .findFirst();

        existingItem.ifPresent(item -> {
            item.setContent(updatedToDoItem.getContent());
            item.setIsCompleted(updatedToDoItem.getIsCompleted());
        });

        return existingItem.orElse(null);
    }

    @Override
    public void deleteToDoItem(Long id) {
        toDoItemList.removeIf(item -> item.getItemId().equals(id));
    }
}
