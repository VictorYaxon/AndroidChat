package org.victoryaxon.chatandroid.login;

/**
 * Created by VictorYaxon on 16/06/2016.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
