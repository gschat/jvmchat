package com.gschat;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;


public class DHKey 
{

    private  String p = "";

    private  String g = "";



    public DHKey(){

    }


    public DHKey(String p, String g ) {
    
        this.p = p;
    
        this.g = g;
    
    }


    public String getP()
    {
        return this.p;
    }
    public void setP(String arg)
    {
        this.p = arg;
    }

    public String getG()
    {
        return this.g;
    }
    public void setG(String arg)
    {
        this.g = arg;
    }



    public void marshal(Writer writer)  throws Exception
    {
        writer.writeByte((byte)2);

        writer.writeByte((byte)com.gsrpc.Tag.String.getValue());
        writer.writeString(p);

        writer.writeByte((byte)com.gsrpc.Tag.String.getValue());
        writer.writeString(g);

    }
    public void unmarshal(Reader reader) throws Exception
    {
        byte __fields = reader.readByte();

        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                p = reader.readString();
            }

            if(-- __fields == 0) {
                return;
            }
        }


        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                g = reader.readString();
            }

            if(-- __fields == 0) {
                return;
            }
        }



        for(int i = 0; i < (int)__fields; i ++) {
            byte tag = reader.readByte();

            if (tag == com.gsrpc.Tag.Skip.getValue()) {
                continue;
            }

            reader.readSkip(tag);
        }
    }

}
