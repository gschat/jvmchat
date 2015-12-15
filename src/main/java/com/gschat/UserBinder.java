package com.gschat;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;



public interface UserBinder {
    String NAME = "com.gschat.UserBinder";

    void bindUser (String userid, Device device) throws Exception;

    void unbindUser (String userid, Device device) throws Exception;

}

