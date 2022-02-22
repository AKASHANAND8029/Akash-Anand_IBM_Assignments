package com.example.todorestapi;

import com.example.todorestapi.model.ToDo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ToDoRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoRestApiApplication.class, args);
    }

@Bean
    public List<ToDo> list() {

        return new ArrayList<>();
    }
}

