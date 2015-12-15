package com.gschat;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;



/*
 * UserResolver generate by gs2java,don't modify it manually
 */
public final class UserResolverDispatcher implements com.gsrpc.NamedDispatcher {

    private UserResolver service;

    public UserResolverDispatcher(UserResolver service) {
        this.service = service;
    }

    public String name() {
        return "com.gschat.UserResolver";
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


                
                
                try{
                
                    UserGroup ret = this.service.queryGroup(arg0);

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
        
        case 1: {
				String arg0 = "";

				{

					com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(call.getParams()[0].getContent());

					arg0 = reader.readString();

				}


                
                
                    BlockRules ret = this.service.queryBlockRules(arg0);

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

                
                
            }
        
        }
        return null;
    }
}
