package com.gschat;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;


public class BlockRules 
{

    private  BlockRule[] rules = new BlockRule[0];

    private  int version = 0;



    public BlockRules(){

    }


    public BlockRules(BlockRule[] rules, int version ) {
    
        this.rules = rules;
    
        this.version = version;
    
    }


    public BlockRule[] getRules()
    {
        return this.rules;
    }
    public void setRules(BlockRule[] arg)
    {
        this.rules = arg;
    }

    public int getVersion()
    {
        return this.version;
    }
    public void setVersion(int arg)
    {
        this.version = arg;
    }



    public void marshal(Writer writer)  throws Exception
    {
        writer.writeByte((byte)2);

        writer.writeByte((byte)((com.gsrpc.Tag.Table.getValue() << 4)|com.gsrpc.Tag.List.getValue()));
        writer.writeUInt16((short)rules.length);

		for(BlockRule v3 : rules){

			v3.marshal(writer);

		}

        writer.writeByte((byte)com.gsrpc.Tag.I32.getValue());
        writer.writeUInt32(version);

    }
    public void unmarshal(Reader reader) throws Exception
    {
        byte __fields = reader.readByte();

        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                int max3 = reader.readUInt16();

		rules = new BlockRule[max3];

		for(int i3 = 0; i3 < max3; i3 ++ ){

			BlockRule v3 = new BlockRule();

			v3.unmarshal(reader);

			rules[i3] = v3;

		}
            }

            if(-- __fields == 0) {
                return;
            }
        }


        {
            byte tag = reader.readByte();

            if(tag != com.gsrpc.Tag.Skip.getValue()) {
                version = reader.readUInt32();
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
