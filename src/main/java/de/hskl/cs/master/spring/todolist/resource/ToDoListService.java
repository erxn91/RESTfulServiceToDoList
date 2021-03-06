package de.hskl.cs.master.spring.todolist.resource;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListService {

    private List<User> _userList;

    public ToDoListService() {
        this._userList = new ArrayList<>();
    }

    public boolean addUser(User user) {
        if(user.getFirstname() != null && user.getLastname() != null) {
            return this._userList.add(user);
        }
        return false;
    }

    public boolean addToDo(int id, ToDo toDo) {
        for(User user : this._userList) {
            if(user.getID() == id) {
                return user.addToDo(toDo);
            }
        }
        return false;
    }

    public boolean removeToDo(int id, ToDo toDo) {
        for(User user : this._userList) {
            if(user.getID() == id) {
                return user.removeToDo(toDo.getID());
            }
        }
        return false;
    }

    public boolean removeUser(int id) {
        for(User user : this._userList) {
            if(user.getID() == id) {
                return this._userList.remove(user);
            }
        }
        return false;
    }

    public void updateCompletion(int userID, int toDoID, boolean complete) {
        List<ToDo> toDos = getToDos(userID);
        if(toDos != null) {
            for(ToDo toDo : toDos) {
                if(toDo.getID() == toDoID) {
                    toDo.setCompleted(complete);
                }
            }
        }
    }

    public List<User> getUserList() {
        return this._userList;
    }

    public List<User> getUsersWithFirstname(String firstname) {
        List<User> userList = new ArrayList<>();
        for(User user : this._userList) {
            if(user.getFirstname().equals(firstname)) userList.add(user);
        }
        return userList;
    }

    public List<User> getUsersWithLastname(String lastname) {
        List<User> userList = new ArrayList<>();
        for(User user : this._userList) {
            if(user.getLastname().equals(lastname)) userList.add(user);
        }
        return userList;
    }

    public User getUser(int id) {
        for(User user : this._userList) {
            if(user.getID() == id) return user;
        }
        return null;
    }

    public List<ToDo> getToDos(int userID) {
        for(User user : this._userList) {
            if(user.getID() == userID) {
                return user.getToDoList();
            }
        }
        return null;
    }

    public void changeFirstname(int id, String firstname) {
        for(User user : this._userList) {
            if(user.getID() == id) {
                user.setFirstname(firstname);
                return;
            }
        }
    }

    public void changeLastname(int id, String lastname) {
        for(User user : this._userList) {
            if(user.getID() == id) {
                user.setLastname(lastname);
                return;
            }
        }
    }
}
