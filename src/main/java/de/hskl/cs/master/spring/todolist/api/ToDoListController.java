package de.hskl.cs.master.spring.todolist.api;

import de.hskl.cs.master.spring.todolist.resource.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/toDoList")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/users")
    public ResponseEntity<List> getUsers() {
        List result = toDoListService.getUserList();
        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @GetMapping(path = "users", params = "firstname")
    public ResponseEntity<List> getUsersWithFirstname(@RequestParam(value = "firstname") String firstname) {
        List result = toDoListService.getUsersWithFirstname(firstname);
        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @GetMapping(path = "users", params = "lastname")
    public ResponseEntity<List> getUsersWithLastname(@RequestParam(value = "lastname") String lastname) {
        List result = toDoListService.getUsersWithLastname(lastname);
        return new ResponseEntity<>( result, HttpStatus.OK );
    }
}
