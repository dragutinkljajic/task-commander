package com.example.android.taskcommander.model;

import java.util.Date;

/**
 * Created by Tea on 3/31/2018.
 */

public class Message {
    private int uid;
    private Date timestamp;
    private String content;

    public Message(int uid, Date timestamp, String content) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
