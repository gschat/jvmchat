package com.gschat;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;


/*
 * DHKeyResolver generate by gs2java,don't modify it manually
 */
public final class DHKeyResolverRPC {

    /**
     * gsrpc net interface
     */
    private com.gsrpc.Channel net;

    /**
     * remote service id
     */
    private short serviceID;

    public DHKeyResolverRPC(com.gsrpc.Channel net, short serviceID){
        this.net = net;
        this.serviceID = serviceID;
    }

    public DHKeyResolverRPC(com.gsrpc.Channel net) throws Exception {
        this.net = net;
        this.serviceID = com.gsrpc.Register.getInstance().getID(DHKeyResolver.NAME);
    }

    
    public com.gsrpc.Future<DHKey> dHKeyResolve(Device arg0, final int timeout) throws Exception {

        com.gsrpc.Request request = new com.gsrpc.Request();

        request.setService(this.serviceID);

        request.setMethod((short)0);

        
        com.gsrpc.Param[] params = new com.gsrpc.Param[1];
		{

			com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

			arg0.marshal(writer);

			com.gsrpc.Param param = new com.gsrpc.Param();

			param.setContent(writer.getContent());

			params[0] = (param);

		}


        request.setParams(params);
        

        
        com.gsrpc.Promise<DHKey> promise = new com.gsrpc.Promise<DHKey>(timeout){
            @Override
            public void Return(Exception e,com.gsrpc.Response callReturn){

                if (e != null) {
                    Notify(e,null);
                    return;
                }

                try{

                    if(callReturn.getException() != (byte)-1) {
                        switch(callReturn.getException()) {
                            
                            case 0:{
                            com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(callReturn.getContent());

                            ResourceNotFoundException exception = new ResourceNotFoundException();

                            exception.unmarshal(reader);

                            Notify(exception,null);

                            return;
                        }
                        
                        default:
                            Notify(new com.gsrpc.RemoteException(),null);
                            return;
                        }
                    }

                    
					DHKey returnParam = new DHKey();

					{

						com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(callReturn.getContent());

						returnParam.unmarshal(reader);

					}


                    Notify(null,returnParam);
                    
                }catch(Exception e1) {
                    Notify(e1,null);
                }
            }
        };

        this.net.send(request,promise);

        return promise;
        
    }
    
}
