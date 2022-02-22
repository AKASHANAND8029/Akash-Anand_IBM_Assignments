package com.example.todorestapi.repository;

import com.example.todorestapi.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
@Repository
public class ToDoRepositoryImpl implements ToDoRepository{

    private final List<ToDo> list;
@Autowired
    public ToDoRepositoryImpl(List<ToDo> list) {
        this.list = list;
    }

    @Override
    public ToDo createTask(ToDo todo) {
    todo.setId(new Random().nextInt(1000));
        list.add(todo);
        return todo;
    }

    @Override
    public List<ToDo> getAllTasks() {
        System.out.println(list);
        return list;
    }

    @Override
    public ToDo findTaskById(Integer id) {
        return list.get(id);
    }

    @Override
    public void deleteTaskById(Integer id) {
        list.remove(id);

    }

    @Override
    public ToDo updateTask(ToDo todo, Integer id) {
        ToDo tempToDo=findTaskById(id);
        tempToDo.setId(todo.getId());
        tempToDo.setTodoName(todo.getTodoName());
        tempToDo.setComplete(todo.getisComplete());
        return tempToDo;
    }
}
