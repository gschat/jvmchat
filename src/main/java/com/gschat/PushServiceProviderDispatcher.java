package com.gschat;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;



/*
 * PushServiceProvider generate by gs2java,don't modify it manually
 */
public final class PushServiceProviderDispatcher implements com.gsrpc.NamedDispatcher {

    private PushServiceProvider service;

    public PushServiceProviderDispatcher(PushServiceProvider service) {
        this.service = service;
    }

    public String name() {
        return "com.gschat.PushServiceProvider";
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

				boolean arg1 = false;

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[1].getContent());

					arg1 = reader.readBoolean();

				}


                
                
                    this.service.deviceStatusChanged(arg0, arg1);

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

				boolean arg2 = false;

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[2].getContent());

					arg2 = reader.readBoolean();

				}


                
                
                    this.service.userStatusChanged(arg0, arg1, arg2);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    

                    return callReturn;

                
                
            }
        
        case 2: {
				Device arg0 = new Device();

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0.unmarshal(reader);

				}

				byte[] arg1 = new byte[0];

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[1].getContent());

					arg1 = reader.readBytes();

				}


                
                
                    this.service.deviceRegister(arg0, arg1);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    

                    return callReturn;

                
                
            }
        
        case 3: {
				Device arg0 = new Device();

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0.unmarshal(reader);

				}


                
                
                    this.service.deviceUnregister(arg0);

                    com.gsrpc.Response callReturn = new com.gsrpc.Response();
                    callReturn.setID(call.getID());
                    callReturn.setException((byte)-1);

                    

                    return callReturn;

                
                
            }
        
        }
        return null;
    }
}
