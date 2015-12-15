package com.gschat;

import com.gschat.ResourceBusyException;

import com.gschat.Mail;

import com.gschat.UnexpectSQIDException;

import com.gsrpc.Device;

import com.gsrpc.KV;

import com.gschat.ResourceNotFoundException;

import com.gschat.UserNotFoundException;

import com.gschat.UserAuthFailedException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;



public interface Push {
    String NAME = "com.gschat.Push";

    void register (byte[] pushToken) throws Exception;

    void unregister () throws Exception;

}

