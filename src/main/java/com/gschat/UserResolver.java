package com.gschat;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;



public interface UserResolver {
    String NAME = "com.gschat.UserResolver";

    UserGroup queryGroup (String groupID) throws Exception;

    BlockRules queryBlockRules (String userID) throws Exception;

}

