package org.victoryaxon.chatandroid.chat;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public interface ChatRepository {
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void subscribe();
    void unsubscribe();
    void destroyListener();
    void changeConnectionStatus(boolean online);
}
