package com.gschat;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;



/*
 * UserBinder generate by gs2java,don't modify it manually
 */
public final class UserBinderDispatcher implements com.gsrpc.NamedDispatcher {

    private UserBinder service;

    public UserBinderDispatcher(UserBinder service) {
        this.service = service;
    }

    public String name() {
        return "com.gschat.UserBinder";
    }

    public com.gsrpc.Response dispatch(com.gsrpc.Request call) throws Exception
    {
        switch(call.getMethod()){
        
        case 0: {
				String arg0 = "";

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0 = reader.readString();

				}

				Device arg1 = new Device();

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[1].getContent());

					arg1.unmarshal(reader);

				}


                
                
                    this.service.bindUser(arg0, arg1);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    

                    return callReturn;

                
                
            }
        
        case 1: {
				String arg0 = "";

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0 = reader.readString();

				}

				Device arg1 = new Device();

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[1].getContent());

					arg1.unmarshal(reader);

				}


                
                
                    this.service.unbindUser(arg0, arg1);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    

                    return callReturn;

                
                
            }
        
        }
        return null;
    }
}
