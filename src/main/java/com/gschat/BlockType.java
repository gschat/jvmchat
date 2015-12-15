package com.gschat;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;


/*
 * BlockType generate by gs2java,don't modify it manually
 */
public enum BlockType {
    Discard((byte)0),
	Silence((byte)1);
    private byte value;
    BlockType(byte val){
        this.value = val;
    }
    @Override
    public String toString() {
        switch(this.value)
        {
        
        case 0:
            return "Discard";
        
        case 1:
            return "Silence";
        
        }
        return "BlockType#" + this.value;
    }
    public byte getValue() {
        return this.value;
    }
    public void marshal(Writer writer) throws Exception
    {
         writer.writeByte(getValue()); 
    }
    public static BlockType unmarshal(Reader reader) throws Exception
    {
        byte code =   reader.readByte(); 
        switch(code)
        {
        
        case 0:
            return BlockType.Discard;
        
        case 1:
            return BlockType.Silence;
        
        }
        throw new Exception("unknown enum constant :" + code);
    }
}
