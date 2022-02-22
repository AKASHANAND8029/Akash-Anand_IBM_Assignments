package com.example.demo.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class ToDo {
	@Id
	@Column(name = "id")
	private Integer id=new Random().nextInt(1000);
	@Column(name ="task_name")
	private String taskName;
	@Column(name = "is_complete")
	private boolean isComplete;
	
	public ToDo() {
		super();
	}
	
	public ToDo(Integer id, String taskName, boolean isComplete) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.isComplete = isComplete;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
		

}