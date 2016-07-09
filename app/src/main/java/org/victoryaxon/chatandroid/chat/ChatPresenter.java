package org.victoryaxon.chatandroid.chat;

import org.victoryaxon.chatandroid.chat.event.ChatEvent;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);
    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}