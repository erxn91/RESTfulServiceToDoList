package de.hskl.cs.master.spring.todolist.resource;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int idCounter = 1;
    private int id;
    private String firstname;
    private String lastname;
    private List<ToDo> toDoList;

    public User() {
        this.id = idCounter++;
        this.toDoList = new ArrayList<>();
    }

    public User(String firstname, String lastname) {
        this.id = idCounter++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.toDoList = new ArrayList<>();
    }

    public boolean addToDo(ToDo toDo) {
        return this.toDoList.add(toDo);
    }

    public boolean removeToDo(int id) {
        for(ToDo toDo : this.toDoList) {
            if(toDo.getID() == id) return this.toDoList.remove(toDo);
        }
        return false;
    }

    public int getID() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public List<ToDo> getToDoList() {
        return this.toDoList;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
