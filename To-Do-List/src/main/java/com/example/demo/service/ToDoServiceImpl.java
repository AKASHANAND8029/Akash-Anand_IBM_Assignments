package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ToDo;
import com.example.demo.repo.ToDoRepository;
@Service
public class ToDoServiceImpl implements ToDoService{
	
	private final ToDoRepository todoRepository;
	
@Autowired
	public ToDoServiceImpl(ToDoRepository todoRepository) {
		
		this.todoRepository = todoRepository;
	}

	@Override
	public ToDo createTask(ToDo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

	@Override
	public List<ToDo> getAllTasks() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public ToDo getTask(Integer id) {
		// TODO Auto-generated method stub
		return todoRepository.getById(id);
	}

	@Override
	public void deleteTask(Integer id) {
		ToDo todo=todoRepository.getById(id);
	todoRepository.delete(todo);
		
	}

}
