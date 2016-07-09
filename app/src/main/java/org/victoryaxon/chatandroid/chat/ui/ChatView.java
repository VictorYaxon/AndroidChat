package org.victoryaxon.chatandroid.chat.ui;

import org.victoryaxon.chatandroid.entities.ChatMessage;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public interface ChatView {
    void onMessageReceived(ChatMessage msg);

}
