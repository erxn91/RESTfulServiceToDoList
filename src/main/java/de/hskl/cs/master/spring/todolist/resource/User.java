package de.hskl.cs.master.spring.todolist.resource;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int idCounter = 1;
    private int _id;
    private String _firstname = "";
    private String _lastname = "";
    private List<ToDo> _toDoList;

    public User() {
        this._id = idCounter++;
        this._toDoList = new ArrayList<>();
    }

    public User(String firstname, String lastname) {
        this._id = idCounter++;
        this._firstname = firstname;
        this._lastname = lastname;
        this._toDoList = new ArrayList<>();
    }

    public boolean addToDo(ToDo toDo) {
        return this._toDoList.add(toDo);
    }

    public int getID() {
        return this._id;
    }

    public String getFirstname() {
        return this._firstname;
    }

    public String getLastname() {
        return this._lastname;
    }

    public void setFirstName(String firstname) {
        this._firstname = firstname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }
}
