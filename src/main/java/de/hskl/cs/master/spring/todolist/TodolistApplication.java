package de.hskl.cs.master.spring.todolist;

import de.hskl.cs.master.spring.todolist.resource.ToDoListService;
import de.hskl.cs.master.spring.todolist.resource.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodolistApplication {

    @Autowired
    private static ToDoListService toDoListService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TodolistApplication.class, args);
        toDoListService = context.getBean(ToDoListService.class);
        toDoListService.addUser(new User("Harald", "Töpfer"));
        toDoListService.addUser(new User("Harald", "Töpferer"));
        toDoListService.addUser(new User("Luke", "Skywalker"));
    }
}
