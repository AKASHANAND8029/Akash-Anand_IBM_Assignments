package com.example.todorestapi.repository;

import com.example.todorestapi.model.ToDo;

import java.util.List;

public interface ToDoRepository {
    public ToDo createTask(ToDo todo);
    public List<ToDo> getAllTasks();
    public ToDo findTaskById(Integer id);
    public void deleteTaskById(Integer id);
    public ToDo updateTask(ToDo todo, Integer id);


}
