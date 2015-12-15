package com.gschat.client;

import com.gschat.Mail;

/**
 * Received mail fifo queue
 */
public interface ReceivedQueue {

    void push(Mail mail) throws Exception;

    Mail pop() throws Exception;
}
