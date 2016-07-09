package org.victoryaxon.chatandroid.login.ui;

/**
 * Created by VictorYaxon on 16/06/2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void hideProgress();
    void showProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
