package com.gschat;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;


/*
 * Gateway generate by gs2java,don't modify it manually
 */
public final class GatewayRPC {

    /**
     * gsrpc net interface
     */
    private com.gsrpc.Channel net;

    /**
     * remote service id
     */
    private short serviceID;

    public GatewayRPC(com.gsrpc.Channel net, short serviceID){
        this.net = net;
        this.serviceID = serviceID;
    }

    public GatewayRPC(com.gsrpc.Channel net) throws Exception {
        this.net = net;
        this.serviceID = com.gsrpc.Register.getInstance().getID(Gateway.NAME);
    }

    
}
