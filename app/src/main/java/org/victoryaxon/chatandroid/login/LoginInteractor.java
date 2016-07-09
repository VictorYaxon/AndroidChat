package org.victoryaxon.chatandroid.login;

/**
 * Created by VictorYaxon on 16/06/2016.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
