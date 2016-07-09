package org.victoryaxon.chatandroid.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
@JsonIgnoreProperties({"sentByMe"})
public class ChatMessage {
    private String msg;
    private String sender;
    private boolean sentByMe;

    public ChatMessage(){}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSentByMe() {
        return sentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        this.sentByMe = sentByMe;
    }

    @Override
    public boolean equals(Object o) {
        boolean equal = false;

        if(o instanceof User){
            ChatMessage msg = (ChatMessage) o;
            equal = this.sender.equals(msg.getSender())
                    && this.msg.equals(msg.getMsg()) && this.sentByMe == msg.sentByMe;
        }
        return equal;
    }
}
