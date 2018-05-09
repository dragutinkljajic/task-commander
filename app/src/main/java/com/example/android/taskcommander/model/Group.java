package com.example.android.taskcommander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tea on 3/31/2018.
 */

public class Group implements Serializable{
    @JsonProperty("id")
    private Long uid;
    private String name;

    //foreign keys
    private ArrayList<String> members;
    private ArrayList<Task> tasks;

    public Group() {
        this.tasks = new ArrayList<>();
    }

    public Group(String name) {

        this.name = name;
    }

    public Group(String name, ArrayList<String> members) {

        this.name = name;
        this.members = members;
    }

    public Group(Long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(String email){
        this.members.add(email);
    }
}
