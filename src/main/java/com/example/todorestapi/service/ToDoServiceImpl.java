package com.example.todorestapi.service;

import com.example.todorestapi.model.ToDo;
import com.example.todorestapi.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;
    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo createTask(ToDo todo) {
        return toDoRepository.createTask(todo);
    }

    @Override
    public List<ToDo> getAllTasks() {
        return toDoRepository.getAllTasks();
    }

    @Override
    public ToDo findTaskById(Integer id) {
        return toDoRepository.findTaskById(id);
    }

    @Override
    public void deleteTaskById(Integer id) {
        toDoRepository.deleteTaskById(id);

    }

    @Override
    public ToDo updateTask(ToDo todo, Integer id) {
        return toDoRepository.updateTask(todo,id);
    }
}
