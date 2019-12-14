package com.hfad.todolist;

public class ToDoList {
    private String name;

    public static final ToDoList[] todo = {
            new ToDoList("Home"),
            new ToDoList("Groceries"),
            new ToDoList("School"),
            new ToDoList("Surf Trip")
    };


    private ToDoList(String name) {
        this.name = name;
    }


    public String getName(){
        return name;
    }

    public String toString() {
        return this.name;
    }

}
