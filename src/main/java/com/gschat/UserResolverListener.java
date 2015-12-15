package com.gschat;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;



public interface UserResolverListener {
    String NAME = "com.gschat.UserResolverListener";

    void groupChanged (String groupID) throws Exception;

    void groupRemoved (String groupID) throws Exception;

    void blockRuleChanged (String userID) throws Exception;

}

