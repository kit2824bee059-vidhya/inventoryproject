package com.inventory;

public abstract class User {
    private final int id;
    private final String name;

    protected User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " #" + id + " (" + name + ")";
    }
}
