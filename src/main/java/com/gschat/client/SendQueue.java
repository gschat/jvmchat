package com.gschat.client;

import com.gschat.Mail;

/**
 * the mail send queue service
 */
public interface SendQueue {
    /**
     * push mail into send fifo queue
     * @param mail mail object
     * @throws Exception any exception
     */
    void push(Mail mail) throws Exception;

    /**
     * return the fifo front mail object
     * @return mail object
     * @throws Exception
     */
    Mail pop() throws Exception;
}
