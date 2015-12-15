package com.gschat;

import com.gschat.UnexpectSQIDException;

import com.gsrpc.Device;

import com.gsrpc.KV;

import com.gschat.ResourceNotFoundException;

import com.gschat.ResourceBusyException;

import com.gschat.Mail;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.UserNotFoundException;

import com.gschat.UserAuthFailedException;



public interface Client {
    String NAME = "com.gschat.JVMClient";

    void push (Mail mail) throws Exception;

    void notify (int SQID) throws Exception;

    void deviceStateChanged (Device device, boolean online) throws Exception;

}

