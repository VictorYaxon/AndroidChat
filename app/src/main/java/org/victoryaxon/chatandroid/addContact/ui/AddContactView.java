package org.victoryaxon.chatandroid.addContact.ui;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}