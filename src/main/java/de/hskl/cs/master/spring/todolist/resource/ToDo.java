package de.hskl.cs.master.spring.todolist.resource;

import java.sql.Timestamp;

public class ToDo {

    private static int idCounter = 1;
    private int id;
    private Timestamp creationDate;
    private String description;
    private Timestamp completionDate;
    private boolean completed;

    public ToDo() {
        this.id = idCounter++;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.description = "noch keine Beschreibung";
    }

    public ToDo(String description) {
        this.id = idCounter++;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.description = description;
    }

    public int getID() {
        return this.id;
    }

    public Timestamp getCreationDate() {
        return this.creationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Timestamp getCompletionDate() {
        return this.completionDate;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean complete) {
        this.completed = complete;
        this.completionDate = new Timestamp(System.currentTimeMillis());
    }
}
