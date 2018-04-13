package com.example.android.taskcommander.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tea on 3/31/2018.
 */

public class Group implements Serializable{
    private int uid;
    private String name;

    //foreign keys
    private ArrayList<Member> members;

    public Group(String name) {

        this.name = name;
    }


    public Group(int uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
