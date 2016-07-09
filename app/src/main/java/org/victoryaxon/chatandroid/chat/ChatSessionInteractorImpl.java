package org.victoryaxon.chatandroid.chat;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class ChatSessionInteractorImpl implements ChatSessionInteractor {
    ChatRepository repository;

    public ChatSessionInteractorImpl() {
        repository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);
    }
}