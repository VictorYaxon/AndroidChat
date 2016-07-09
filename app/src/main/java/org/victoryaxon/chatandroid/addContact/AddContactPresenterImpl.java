package org.victoryaxon.chatandroid.addContact;

import org.greenrobot.eventbus.Subscribe;
import org.victoryaxon.chatandroid.addContact.events.AddContactEvent;
import org.victoryaxon.chatandroid.addContact.ui.AddContactView;
import org.victoryaxon.chatandroid.lib.EventBus;
import org.victoryaxon.chatandroid.lib.GreenRobotEventBus;

/**
 * Created by VictorYaxon on 04/07/2016.
 */
public class AddContactPresenterImpl implements AddContactPresenter {
    private EventBus eventBus;
    private AddContactView view;
    private AddContactInteractor interactor;

    public AddContactPresenterImpl(AddContactView view) {
        this.view = view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new AddContactInteractorImpl();
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        if (view != null){
            view.hideInput();
            view.showProgress();
        }
        interactor.execute(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if (view != null){
            view.hideProgress();
            view.showInput();
            if(event.isError()){
                view.contactNotAdded();
            }else{
                view.contactAdded();
            }
        }
    }
}
