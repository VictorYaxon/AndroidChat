package org.victoryaxon.chatandroid.addContact;

import org.victoryaxon.chatandroid.addContact.events.AddContactEvent;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
