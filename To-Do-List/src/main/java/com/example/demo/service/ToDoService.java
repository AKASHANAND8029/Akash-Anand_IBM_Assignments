package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ToDo;

public interface ToDoService {
	
	public ToDo createTask(ToDo customer);
	
	public List<ToDo> getAllTasks();
	
	public ToDo getTask(Integer id);
	
	public void deleteTask(Integer id);

}

