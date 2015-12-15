package com.gschat.client;

import com.gschat.*;
import com.gsrpc.Register;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(BlockJUnit4ClassRunner.class)
public class JVMClientTest {

    private MockJVMClient client;

    public JVMClientTest() throws Exception {

        Map<String,Short> register = new HashMap<String, Short>();

        register.put(Client.NAME,(short) Service.Client.getValue());

        register.put(MailHub.NAME,(short) Service.MailHub.getValue());

        register.put(Auth.NAME,(short) Service.Auth.getValue());

        register.put(Push.NAME,(short) Service.Push.getValue());

        Register.getInstance().update(register);

        client = new MockJVMClient();

        client.reconnect(2, TimeUnit.SECONDS);

    }

    @Test
    public void testConnect() throws Exception {
        client.start();
    }

    @Test
    public void testSendMail() throws Exception
    {

        client.registerListener("test", new MailStateListener() {
            @Override
            public boolean mailStateChanged(Mail mail, MailState state, Exception e) {
                synchronized (JVMClientTest.this){
                    JVMClientTest.this.notify();
                }
                return false;
            }
        });

        synchronized (this){
            this.wait();
        }
    }
}
