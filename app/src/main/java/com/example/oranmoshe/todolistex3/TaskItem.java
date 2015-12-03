package com.example.oranmoshe.todolistex3;

import java.io.Serializable;

/**
 * Created by oranmoshe on 12/2/15.
 */
public class TaskItem implements Serializable {

    private String name;
    private String description;
    TaskItem(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String GetName(){
        return this.name;
    }
    private static final long serialVersionUID = 46543445;
    public String GetDescription(){
        return this.name;
    }

}
