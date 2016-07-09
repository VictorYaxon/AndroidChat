package org.victoryaxon.chatandroid.addContact;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepository repository;

    public AddContactInteractorImpl() {
        this.repository = new AddRepositoryImpl();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);
    }
}

