package com.gschat;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;



/*
 * DHKeyResolver generate by gs2java,don't modify it manually
 */
public final class DHKeyResolverDispatcher implements com.gsrpc.NamedDispatcher {

    private DHKeyResolver service;

    public DHKeyResolverDispatcher(DHKeyResolver service) {
        this.service = service;
    }

    public String name() {
        return "com.gschat.DHKeyResolver";
    }

    public com.gsrpc.Response dispatch(com.gsrpc.Request call) throws Exception
    {
        switch(call.getMethod()){
        
        case 0: {
				Device arg0 = new Device();

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0.unmarshal(reader);

				}


                
                
                try{
                
                    DHKey ret = this.service.dHKeyResolve(arg0);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    
    				byte[] returnParam;

				{

					com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

					ret.marshal(writer);

					returnParam = writer.getContent();

				}


                    callReturn.setContent(returnParam);
                    

                    return callReturn;

                } catch(ResourceNotFoundException e) {

                    com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

                    e.marshal(writer);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)0);
                    callReturn.setContent(writer.getContent());

                    return callReturn;
                }
                
            }
        
        }
        return null;
    }
}
