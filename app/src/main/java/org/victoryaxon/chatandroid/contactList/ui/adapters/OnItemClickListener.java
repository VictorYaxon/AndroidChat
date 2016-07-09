package org.victoryaxon.chatandroid.contactList.ui.adapters;

import org.victoryaxon.chatandroid.entities.User;

/**
 * Created by VictorYaxon on 28/06/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
