package com.gschat;

import com.gsrpc.Reader;

import com.gsrpc.Device;

import com.gsrpc.KV;

import java.nio.ByteBuffer;

import com.gsrpc.Writer;


public class Attachment 
{

    private  AttachmentType type = AttachmentType.Text;

    private  byte[] content = new byte[0];



    public Attachment(){

    }


    public Attachment(AttachmentType type, byte[] content ) {
    
        this.type = type;
    
        this.content = content;
    
    }


    public AttachmentType getType()
    {
        return this.type;
    }
    public void setType(AttachmentType arg)
    {
        this.type = arg;
    }

    public byte[] getContent()
    {
        return this.content;
    }
    public void setContent(byte[] arg)
    {
        this.content = arg;
    }



    public void marshal(Writer writer)  throws Exception
    {
        writer.writeByte((byte)2);

        writer.writeByte((byte)com.gsrpc.Tag.I8.getValue());
        type.marshal(writer);

        writer.writeByte((byte)((com.gsrpc.Tag.I8.getValue() << 4)|com.gsrpc.Tag.List.getValue()));
        writer.writeBytes(content);

    }
    public void unmarshal(Reader reader) throws Exception
    {
        byte __fields = reader.readByte();

        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                type = AttachmentType.unmarshal(reader);
            }

            if(-- __fields == 0) {
                return;
            }
        }


        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                content = reader.readBytes();
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
