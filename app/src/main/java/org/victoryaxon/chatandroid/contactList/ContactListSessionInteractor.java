package org.victoryaxon.chatandroid.contactList;

/**
 * Created by VictorYaxon on 27/06/2016.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
