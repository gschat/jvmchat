package com.gschat;

import java.nio.ByteBuffer;

import com.gschat.UserNotFoundException;

import com.gschat.UserAuthFailedException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import com.gschat.ResourceNotFoundException;

import com.gschat.ResourceBusyException;

import com.gschat.Mail;

import com.gschat.UnexpectSQIDException;

import com.gsrpc.Device;

import com.gsrpc.KV;


/*
 * Auth generate by gs2java,don't modify it manually
 */
public final class AuthRPC {

    /**
     * gsrpc net interface
     */
    private com.gsrpc.Channel net;

    /**
     * remote service id
     */
    private short serviceID;

    public AuthRPC(com.gsrpc.Channel net, short serviceID){
        this.net = net;
        this.serviceID = serviceID;
    }

    public AuthRPC(com.gsrpc.Channel net) throws Exception {
        this.net = net;
        this.serviceID = com.gsrpc.Register.getInstance().getID(Auth.NAME);
    }

    
    public com.gsrpc.Future<KV[]> login(String arg0, KV[] arg1, final int timeout) throws Exception {

        com.gsrpc.Request request = new com.gsrpc.Request();

        request.setService(this.serviceID);

        request.setMethod((short)0);

        
        com.gsrpc.Param[] params = new com.gsrpc.Param[2];
		{

			com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

			writer.writeString(arg0);

			com.gsrpc.Param param = new com.gsrpc.Param();

			param.setContent(writer.getContent());

			params[0] = (param);

		}

		{

			com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

			writer.writeUInt16((short)arg1.length);

		for(KV v3 : arg1){

			v3.marshal(writer);

		}

			com.gsrpc.Param param = new com.gsrpc.Param();

			param.setContent(writer.getContent());

			params[1] = (param);

		}


        request.setParams(params);
        

        
        com.gsrpc.Promise<KV[]> promise = new com.gsrpc.Promise<KV[]>(timeout){
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

                            UserNotFoundException exception = new UserNotFoundException();

                            exception.unmarshal(reader);

                            Notify(exception,null);

                            return;
                        }
                        
                            case 1:{
                            com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(callReturn.getContent());

                            UserAuthFailedException exception = new UserAuthFailedException();

                            exception.unmarshal(reader);

                            Notify(exception,null);

                            return;
                        }
                        
                            case 2:{
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

                    
					KV[] returnParam = new KV[0];

					{

						com.gsrpc.BufferReader reader = new com.gsrpc.BufferReader(callReturn.getContent());

						int max6 = reader.readUInt16();

					returnParam = new KV[max6];

					for(int i6 = 0; i6 < max6; i6 ++ ){

						KV v6 = new KV();

						v6.unmarshal(reader);

						returnParam[i6] = v6;

					}

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
    
    public com.gsrpc.Future<Void> logoff(KV[] arg0, final int timeout) throws Exception {

        com.gsrpc.Request request = new com.gsrpc.Request();

        request.setService(this.serviceID);

        request.setMethod((short)1);

        
        com.gsrpc.Param[] params = new com.gsrpc.Param[1];
		{

			com.gsrpc.BufferWriter writer = new com.gsrpc.BufferWriter();

			writer.writeUInt16((short)arg0.length);

		for(KV v3 : arg0){

			v3.marshal(writer);

		}

			com.gsrpc.Param param = new com.gsrpc.Param();

			param.setContent(writer.getContent());

			params[0] = (param);

		}


        request.setParams(params);
        

        
        com.gsrpc.Promise<Void> promise = new com.gsrpc.Promise<Void>(timeout){
            @Override
            public void Return(Exception e,com.gsrpc.Response callReturn){

                if (e != null) {
                    Notify(e,null);
                    return;
                }

                try{

                    if(callReturn.getException() != (byte)-1) {
                        switch(callReturn.getException()) {
                            
                        default:
                            Notify(new com.gsrpc.RemoteException(),null);
                            return;
                        }
                    }

                    
                    Notify(null,null);
                    
                }catch(Exception e1) {
                    Notify(e1,null);
                }
            }
        };

        this.net.send(request,promise);

        return promise;
        
    }
    
}
