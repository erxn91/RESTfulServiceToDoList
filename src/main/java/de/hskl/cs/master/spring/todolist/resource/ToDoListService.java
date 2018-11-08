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

    public boolean addToDoToUser(int id, ToDo toDo) {
        for(User user : this._userList) {
            if(user.getID() == id) return user.addToDo(toDo);
        }
        return false;
    }

    public boolean removeToDoFromUser(int id, ToDo toDo) {
        for(User user : this._userList) {
            if(user.getID() == id) return user.removeToDo(toDo.getID());
        }
        return false;
    }

    public boolean removeUser(int id) {
        for(User user : this._userList) {
            if(user.getID() == id) return this._userList.remove(user);
        }
        return false;
    }

    public void changeUserFirstname(int id, String firstname) {
        for(User user : this._userList) {
            if(user.getID() == id) user.setFirstName(firstname);
        }
    }

    public void changeUserLastname(int id, String lastname) {
        for(User user : this._userList) {
            if(user.getID() == id) user.setLastname(lastname);
        }
    }

    public List<User> getUserList() {
        return this._userList;
    }
}
