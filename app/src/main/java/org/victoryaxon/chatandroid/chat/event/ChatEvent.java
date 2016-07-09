package org.victoryaxon.chatandroid.chat.event;

import org.victoryaxon.chatandroid.entities.ChatMessage;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class ChatEvent {
    ChatMessage message;

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
