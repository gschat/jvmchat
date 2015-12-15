package com.gschat;

import com.gsrpc.Reader;

import java.nio.ByteBuffer;

import com.gschat.Mail;

import com.gsrpc.Device;

import com.gschat.UserNotFoundException;

import com.gschat.ResourceNotFoundException;

import com.gsrpc.Writer;


public class UserGroup 
{

    private  String[] users = new String[0];

    private  int version = 0;



    public UserGroup(){

    }


    public UserGroup(String[] users, int version ) {
    
        this.users = users;
    
        this.version = version;
    
    }


    public String[] getUsers()
    {
        return this.users;
    }
    public void setUsers(String[] arg)
    {
        this.users = arg;
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

        writer.writeByte((byte)((com.gsrpc.Tag.String.getValue() << 4)|com.gsrpc.Tag.List.getValue()));
        writer.writeUInt16((short)users.length);

		for(String v3 : users){

			writer.writeString(v3);

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

		users = new String[max3];

		for(int i3 = 0; i3 < max3; i3 ++ ){

			String v3 = "";

			v3 = reader.readString();

			users[i3] = v3;

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
