package com.example.android.taskcommander.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tea on 3/31/2018.
 */

public class Task implements Serializable{
    @JsonProperty("id")
    private Long uid;
    @JsonProperty("name")
    private String caption;

    private String description;
    private Date deadline;
    @JsonProperty("completed")
    private boolean isComplete = false;

    //foreign keys
    private int creator_uid;
    private int asignee_uid;

    public Task() {

    }

    public Task(Long uid, String caption, String description, Date deadline, boolean isComplete, int creator_uid, int asignee_uid) {
        this.uid = uid;
        this.caption = caption;
        this.description = description;
        this.deadline = deadline;
        this.isComplete = isComplete;
        this.creator_uid = creator_uid;
        this.asignee_uid = asignee_uid;
    }

    public Task(String caption, String description, Date deadline) {
        this.caption = caption;
        this.description = description;
        this.deadline = deadline;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getCreator_uid() {
        return creator_uid;
    }

    public void setCreator_uid(int creator_uid) {
        this.creator_uid = creator_uid;
    }

    public int getAsignee_uid() {
        return asignee_uid;
    }

    public void setAsignee_uid(int asignee_uid) {
        this.asignee_uid = asignee_uid;
    }
}
