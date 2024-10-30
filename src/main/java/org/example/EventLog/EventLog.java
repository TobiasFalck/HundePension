package org.example.EventLog;

public class EventLog {
    private int id;
    private String description;
    private String health;

    public EventLog(String description, String health) {
        this.description = description;
        this.health = health;
    }
    public EventLog () {
        //What doing?
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
