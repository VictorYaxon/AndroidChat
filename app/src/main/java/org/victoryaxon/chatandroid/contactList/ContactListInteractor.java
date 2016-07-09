 package org.victoryaxon.chatandroid.contactList;

 /**
  * Created by VictorYaxon on 27/06/2016.
  */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
