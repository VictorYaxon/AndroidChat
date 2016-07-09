package org.victoryaxon.chatandroid.contactList.ui;


import org.victoryaxon.chatandroid.entities.User;

/**
 * Created by VictorYaxon on 27/06/2016.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
