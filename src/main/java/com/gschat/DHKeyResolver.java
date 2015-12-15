package com.gschat;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;



public interface DHKeyResolver {
    String NAME = "com.gschat.DHKeyResolver";

    DHKey dHKeyResolve (Device device) throws Exception;

}

