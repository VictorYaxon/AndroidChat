package org.victoryaxon.chatandroid.chat;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class ChatInteractorImpl implements ChatInteractor {
    ChatRepository repository;

    public ChatInteractorImpl() {
        repository = new ChatRepositoryImpl();
    }

    @Override
    public void sendMessage(String msg) {
        repository.sendMessage(msg);
    }

    @Override
    public void setRecipient(String recipient) {
        repository.setRecipient(recipient);
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }
}
