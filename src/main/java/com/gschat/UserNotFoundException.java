package com.gschat;

import java.nio.ByteBuffer;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import com.gsrpc.Device;

import com.gsrpc.KV;


public class UserNotFoundException extends Exception
{




    public UserNotFoundException() {
    
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
