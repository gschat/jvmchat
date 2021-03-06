package com.gschat;

import com.gsrpc.KV;

import java.nio.ByteBuffer;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import com.gsrpc.Device;


public class UserAuthFailedException extends Exception
{




    public UserAuthFailedException() {
    
    }




    public void marshal(Writer writer)  throws Exception
    {
        writer.writeByte((byte)0);

    }
    public void unmarshal(Reader reader) throws Exception
    {
        byte __fields = reader.readByte();


        for(int i = 0; i < (int)__fields; i ++) {
            byte tag = reader.readByte();

            if (tag == com.gsrpc.Tag.Skip.getValue()) {
                continue;
            }

            reader.readSkip(tag);
        }
    }

}
