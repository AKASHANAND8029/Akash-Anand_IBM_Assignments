package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;

@Controller
@RequestMapping
public class ToDoController {

	private final ToDoService todoService;

	@Autowired
	public ToDoController(ToDoService todoService) {
		this.todoService=todoService;
	}

	@GetMapping("/")
	public String listTasks(Model theModel) {

		// get customers from the service
		List<ToDo> theToDos = todoService.getAllTasks();

		// add the customers to the model
		theModel.addAttribute("todos", theToDos);

		return "list-tasks";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		ToDo theToDo = new ToDo();

		theModel.addAttribute("todo", theToDo);

		return "task-form";
	}

	@PostMapping("/saveToDo")
	public String saveToDo(@ModelAttribute("todo") ToDo theToDo) {

		// save the customer using our service
		todoService.createTask(theToDo);
		

		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("todoId") int theId, Model theModel) {

		// get the customer from our service
		ToDo theToDo = todoService.getTask(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("todo", theToDo);

		// send over to our form
		return "task-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("todoId") int theId) {

		// delete the customer
		todoService.deleteTask(theId);
		

		return "redirect:/";
	}
}