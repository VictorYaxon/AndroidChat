package org.victoryaxon.chatandroid.addContact.events;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class AddContactEvent {
    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
