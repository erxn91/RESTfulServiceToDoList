package de.hskl.cs.master.spring.todolist.resource;

import java.util.Date;

public class ToDo {

    private static int idCounter = 1;
    private int _id;
    private Date _creationDate;
    private String _description;
    private Date _completionDate;
    private boolean _completed;

    public ToDo(String description) {
        this._id = idCounter++;
        this._description = description;
    }

    public int getID() {
        return this._id;
    }

    public Date getCreationDate() {
        return this._creationDate;
    }

    public String getDescription() {
        return this._description;
    }

    public Date getCompletionDate() {
        return this._completionDate;
    }

    public boolean getCompleted() {
        return this._completed;
    }

    public void setCompleted(boolean complete) {
        this._completed = complete;
    }
}
