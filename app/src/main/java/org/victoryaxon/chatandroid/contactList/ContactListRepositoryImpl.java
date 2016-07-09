package org.victoryaxon.chatandroid.contactList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

import org.victoryaxon.chatandroid.contactList.events.ContactListEvent;
import org.victoryaxon.chatandroid.domain.FirebaseHelper;
import org.victoryaxon.chatandroid.entities.User;
import org.victoryaxon.chatandroid.lib.EventBus;
import org.victoryaxon.chatandroid.lib.GreenRobotEventBus;


/**
 * Created by VictorYaxon on 27/06/2016.
 */
public class ContactListRepositoryImpl implements ContactListRepository {
    private FirebaseHelper helper;
    private ChildEventListener contactEventListener;
    private EventBus eventBus;

    public ContactListRepositoryImpl() {
        eventBus = GreenRobotEventBus.getInstance();
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signOff() {
        helper.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return helper.getAuthUserEmail();
    }

    @Override
    public void removeContact(String email) {
        String currentUserEmail = helper.getAuthUserEmail();
        helper.getOneContactReference(currentUserEmail, email).removeValue();
        helper.getOneContactReference(email, currentUserEmail).removeValue();
    }

    @Override
    public void destroyListener() {
        contactEventListener = null;
    }

    @Override
    public void subscribeToContactListEvents() {
        if(contactEventListener == null) {
            contactEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.onContactAdded);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.onContactChanged);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    handleContact(dataSnapshot, ContactListEvent.onContactRemoved);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

                @Override
                public void onCancelled(FirebaseError firebaseError) {}
            };
        }
        helper.getMyContactsReference().addChildEventListener(contactEventListener);
    }

    private void handleContact(DataSnapshot dataSnapshot, int type) {
        String email = dataSnapshot.getKey();
        email = email.replace("_", ".");
        boolean online = ((Boolean) dataSnapshot.getValue()).booleanValue();
        User user = new User();
        user.setOnline(online);
        user.setEmail(email);
        post(type, user);
    }

    public void post(int type, User user){
        ContactListEvent event = new ContactListEvent();
        event.setEventType(type);
        event.setUser(user);
        eventBus.post(event);
    }

    @Override
    public void unsubscribeToContactListEvents() {
        if(contactEventListener != null){
            helper.getMyContactsReference().removeEventListener(contactEventListener);
        }
    }

    @Override
    public void changeConnectionStatus(boolean online) {

    }
}
