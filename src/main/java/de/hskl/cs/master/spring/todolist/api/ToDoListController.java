package de.hskl.cs.master.spring.todolist.api;

import de.hskl.cs.master.spring.todolist.resource.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;
}
