package com.example.todorestapi.controller;

import com.example.todorestapi.model.ToDo;
import com.example.todorestapi.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    private final ToDoService toDoService;
@Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping("/tasks")
    public List<ToDo> getTask()
    {
        return toDoService.getAllTasks();
    }
    @PostMapping("/tasks")
    public ToDo createTask(@RequestBody ToDo todo)
    {
       return toDoService.createTask(todo);
    }
    @GetMapping("/tasks/{id}")
    public ToDo findTask(@PathVariable("id") Integer id)
    {
        ToDo toDo=toDoService.findTaskById(id);
        return toDo;
    }
    @DeleteMapping("/tasks/{id}")
            public String deleteTask(@PathVariable("id") Integer id)
    {toDoService.deleteTaskById(id);
        return "Task Successfully Deleted";

    }
    @PutMapping("/tasks/{id}")
    public ToDo updateTask(@RequestBody ToDo toDo,@PathVariable("id") Integer id)
    {
        return toDoService.updateTask(toDo,id);
    }
}
