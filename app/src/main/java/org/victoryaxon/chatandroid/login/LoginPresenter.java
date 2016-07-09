package org.victoryaxon.chatandroid.login;

import org.victoryaxon.chatandroid.login.event.LoginEvent;

/**
 * Created by VictorYaxon on 16/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
