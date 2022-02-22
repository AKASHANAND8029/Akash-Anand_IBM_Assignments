package com.example.todorestapi.model;

public class ToDo {
    private Integer id;
    private String todoName;
    private boolean isComplete;

    public ToDo() {
    }

    public ToDo(Integer id, String todoName, boolean isComplete) {
        this.id = id;
        this.todoName = todoName;
        this.isComplete = isComplete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean getisComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
