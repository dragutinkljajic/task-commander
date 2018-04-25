package com.example.android.taskcommander.model;

import java.util.Date;

/**
 * Created by Tea on 3/31/2018.
 */

public class Message {

    public final static String MSG_TYPE_SENT = "MSG_TYPE_SENT";

    public final static String MSG_TYPE_RECEIVED = "MSG_TYPE_RECEIVED";

    private int uid;
    private Date timestamp;
    private String content;
    private String msgType;

    public Message(int uid, Date timestamp, String content) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.content = content;
    }

    public Message(String msgType, String content) {
        this.msgType = msgType;
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

    public String getMsgType() { return msgType; }

    public void setMsgType(String msgType) { this.msgType = msgType; }
}
