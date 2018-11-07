package de.hskl.cs.master.spring.todolist.resource;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDoListService {

    private List<User> _userList;

    public ToDoListService() {
        this._userList = new ArrayList<>();
    }

    public boolean addUser() {
        User user = new User();
        return this._userList.add(user);
    }

    public boolean addUser(String firstname, String lastname) {
        User user = new User(firstname, lastname);
        return this._userList.add(user);
    }
}
