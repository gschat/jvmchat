package com.gschat;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;



/*
 * Gateway generate by gs2java,don't modify it manually
 */
public final class GatewayDispatcher implements com.gsrpc.NamedDispatcher {

    private Gateway service;

    public GatewayDispatcher(Gateway service) {
        this.service = service;
    }

    public String name() {
        return "com.gschat.Gateway";
    }

    public com.gsrpc.Response dispatch(com.gsrpc.Request call) throws Exception
    {
        switch(call.getMethod()){
        
        }
        return null;
    }
}
