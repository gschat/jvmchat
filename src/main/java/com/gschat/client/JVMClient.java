package com.gschat.client;


import com.gschat.*;
import com.gsrpc.net.DHKeyResolver;
import com.gsrpc.Device;
import com.gsrpc.Register;
import com.gsrpc.net.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * the gschat jvm client implement
 */
public abstract class JVMClient implements DHKeyResolver,RemoteResolver,Client {

    /**
     * client bind device name
     */
    private final Device device;

    /**
     * the gsrpc tcp client builder
     */
    private final TCPClientBuilder clientBuilder;

    /**
     * register mail state changed listeners
     */
    private final ConcurrentHashMap<String,MailStateListener> listeners =
            new ConcurrentHashMap<String,MailStateListener>();

    /**
     * the heartbeat relay duration
     */
    private int relay;
    /**
     * the heartbeat relay duration unit
     */
    private TimeUnit unit;

    /**
     * the underground tcp client object
     */
    private TCPClient tcpClient;

    /**
     * MailHub rpc agent
     */
    private MailHubRPC mailHub;

    /**
     * Auth service agent
     */
    private AuthRPC auth;

    /**
     * Push service agent;
     */
    private PushRPC push;

    /**
     * create new jvm client by device name
     * @param device the client bind device name
     */
    public JVMClient(Device device)
    {

        this.device = device;

        clientBuilder = new TCPClientBuilder(this);
    }

    /**
     * set the jvm client reconnect parameters
     * @param relay reconnect relay time duration
     * @param unit relay time unit
     * @return client object
     */
    public JVMClient reconnect(int relay, TimeUnit unit) {

        clientBuilder.reconnect(relay,unit);

        return this;
    }

    /**
     * update heartbeat timeout
     * @param relay heartbeat relay val
     * @param unit relay unit
     * @return the JVMClient object
     */
    public JVMClient heartbeat(int relay, TimeUnit unit){

        this.relay = relay;
        this.unit = unit;

        return this;
    }

    /**
     * set the task executor
     * @param executor task executor
     * @return client self
     */
    public JVMClient executor(Executor executor) {
        clientBuilder.dispacherExecutor(executor);
        return this;
    }

    /**
     * set the io timeout timer
     * @param wheelTimer wheel timer object
     * @return JVMClient
     */
    public JVMClient timewheel(HashedWheelTimer wheelTimer)
    {
        clientBuilder.wheelTimer(wheelTimer);
        return this;
    }

    /**
     * start the jvm client object
     */
    public void start() throws Exception
    {
        tcpClient = clientBuilder.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new DHClientHandler(device, JVMClient.this));

                ch.pipeline().addLast(new HeartbeatEchoHandler(relay, unit));
            }
        }).build();

        tcpClient.connect();

        // register client service
        tcpClient.registerDispatcher(new ClientDispatcher(this));

        // bind service agents
        mailHub = new MailHubRPC(tcpClient, Register.getInstance().getID(MailHub.NAME));
        auth = new AuthRPC(tcpClient,Register.getInstance().getID(Auth.NAME));
        push = new PushRPC(tcpClient,Register.getInstance().getID(Push.NAME));
    }

    /**
     * close the client
     */
    public void close() {
        if(tcpClient != null){
            tcpClient.close();
        }
    }

    public void send(Mail mail) throws Exception
    {

    }

    /**
     * register mail state listener by name
     * @param listener listener
     * @return  the previous value associated with the specified key, or null if there was no mapping for the key.
     *          (A null return can also indicate that the map previously associated null with the key,
     *          if the implementation supports null values.)
     */
    public MailStateListener registerListener(String name, MailStateListener listener)
    {
        return listeners.putIfAbsent(name,listener);
    }

    /**
     * unregister mail state listener by register name
     * @param name register listener name
     */
    public void unregisterListener(String name)
    {
        listeners.remove(name);
    }


    @Override
    public void push(Mail mail) throws Exception {

    }

    @Override
    public void notify(int ID) throws Exception {

    }

    @Override
    public void deviceStateChanged(Device device, boolean online) throws Exception {

    }


}
