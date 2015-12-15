package com.gschat.client;

import com.gschat.Mail;

/**
 * The mail state changed listener
 */
public interface MailStateListener {

    /**
     * notify the mail state changed
     * @param mail event source
     * @param state new state of mail
     * @param e not null if something error occur
     * @return if listener handle this event return true,otherwise return false
     */
    boolean mailStateChanged(Mail mail,MailState state,Exception e);

}
