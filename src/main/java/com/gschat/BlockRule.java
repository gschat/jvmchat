package com.gschat;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;


public class BlockRule 
{

    private  String target = "";

    private  BlockType blockType = BlockType.Discard;



    public BlockRule(){

    }


    public BlockRule(String target, BlockType blockType ) {
    
        this.target = target;
    
        this.blockType = blockType;
    
    }


    public String getTarget()
    {
        return this.target;
    }
    public void setTarget(String arg)
    {
        this.target = arg;
    }

    public BlockType getBlockType()
    {
        return this.blockType;
    }
    public void setBlockType(BlockType arg)
    {
        this.blockType = arg;
    }



    public void marshal(Writer writer)  throws Exception
    {
        writer.writeByte((byte)2);

        writer.writeByte((byte)com.gsrpc.Tag.String.getValue());
        writer.writeString(target);

        writer.writeByte((byte)com.gsrpc.Tag.I8.getValue());
        blockType.marshal(writer);

    }
    public void unmarshal(Reader reader) throws Exception
    {
        byte __fields = reader.readByte();

        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                target = reader.readString();
            }

            if(-- __fields == 0) {
                return;
            }
        }


        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                blockType = BlockType.unmarshal(reader);
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
