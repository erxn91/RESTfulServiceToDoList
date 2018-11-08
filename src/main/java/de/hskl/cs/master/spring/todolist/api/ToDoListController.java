package de.hskl.cs.master.spring.todolist.api;

import de.hskl.cs.master.spring.todolist.resource.ToDo;
import de.hskl.cs.master.spring.todolist.resource.ToDoListService;
import de.hskl.cs.master.spring.todolist.resource.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if(toDoListService.addUser(user)) {
            return new ResponseEntity<>( user, HttpStatus.OK );
        }
        return new ResponseEntity<>( HttpStatus.CONFLICT );
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<?> addToDo(@PathVariable int id, @RequestBody ToDo toDo) {
        if(toDoListService.addToDo( id, toDo )) {
            return new ResponseEntity<>( toDo, HttpStatus.OK );
        }
        return new ResponseEntity<>( HttpStatus.CONFLICT );
    }

    @PostMapping("users/{userID}/{toDoID}")
    public ResponseEntity<?> changeToDoCompletion(@PathVariable int userID,
                                                  @PathVariable int toDoID,
                                                  @RequestBody boolean complete) {
        if(complete) {
            toDoListService.completeToDo(userID, toDoID);
        }
        else {
            toDoListService.uncompleteToDo(userID, toDoID);
        }
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @GetMapping("/users")
    public ResponseEntity<List> getUsers() {
        List result = toDoListService.getUserList();
        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable int id) {
        User result = toDoListService.getUser(id);
        if(result != null) {
            return new ResponseEntity<>( result, HttpStatus.OK );
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
