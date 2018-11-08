package de.hskl.cs.master.spring.todolist;

import de.hskl.cs.master.spring.todolist.resource.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodolistApplication {

    private static ToDoListService toDoListService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TodolistApplication.class, args);
        toDoListService = context.getBean(ToDoListService.class);
        toDoListService.addUser("Harald", "Töpfer");
        toDoListService.addUser("Luke", "Skywalker");
        toDoListService.addUser("James", "Bond");
        toDoListService.addUser("Harald", "Töpferer");
    }
}
