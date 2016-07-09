package org.victoryaxon.chatandroid.contactList;


import org.victoryaxon.chatandroid.contactList.events.ContactListEvent;

/**
 * Created by VictorYaxon on 27/06/2016.
 */
public interface ContactListPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
