package com.samar.bootcamp.todo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class ToDoList {
    private Long id;
    private Long todoCount = 0L;
    private List<ToDoItem> item;

    public ToDoList(Long id, Long itemCount) {
        this.id = id;
        this.todoCount = itemCount;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ToDoItem {
        private Long itemId;
        private String content;
        private Boolean isCompleted = false;
    }
}
