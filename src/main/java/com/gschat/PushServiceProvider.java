package com.gschat;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;



public interface PushServiceProvider {
    String NAME = "com.gschat.PushServiceProvider";

    void deviceStatusChanged (Device device, boolean online) throws Exception;

    void userStatusChanged (String userID, Device device, boolean online) throws Exception;

    void deviceRegister (Device device, byte[] token) throws Exception;

    void deviceUnregister (Device device) throws Exception;

}

