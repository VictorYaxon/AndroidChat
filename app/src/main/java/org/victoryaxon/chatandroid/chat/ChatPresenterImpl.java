package org.victoryaxon.chatandroid.chat;

import org.greenrobot.eventbus.Subscribe;
import org.victoryaxon.chatandroid.chat.event.ChatEvent;
import org.victoryaxon.chatandroid.chat.ui.ChatView;
import org.victoryaxon.chatandroid.entities.User;
import org.victoryaxon.chatandroid.lib.EventBus;
import org.victoryaxon.chatandroid.lib.GreenRobotEventBus;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class ChatPresenterImpl implements ChatPresenter {
    private EventBus eventBus;
    private ChatView view;
    private ChatInteractor chatInteractor;
    private ChatSessionInteractor sessionInteractor;

    public ChatPresenterImpl(ChatView view) {
        this.view = view;
        eventBus = GreenRobotEventBus.getInstance();
        this.chatInteractor = new ChatInteractorImpl();
        this.sessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onPause() {
        chatInteractor.unsubscribe();
        sessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribe();
        sessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        chatInteractor.destroyListener();
        view = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ChatEvent event) {
        if (view != null) {
            view.onMessageReceived(event.getMessage());
        }
    }
}

