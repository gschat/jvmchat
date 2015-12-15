package com.gschat.client;

import com.gsrpc.Device;
import com.gsrpc.net.DHKey;

import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.UUID;


public class MockJVMClient extends JVMClient {

    public MockJVMClient() {
        super(createDevice());
    }

    private static Device createDevice() {
        Device device = new Device();

        device.setID(UUID.randomUUID().toString());

        return device;
    }


    @Override
    public DHKey resolver(Device device) throws Exception {
        return new DHKey(
                new BigInteger("6849211231874234332173554215962568648211715948614349192108760170867674332076420634857278025209099493881977517436387566623834457627945222750416199306671083"),
                new BigInteger("13196520348498300509170571968898643110806720751219744788129636326922565480984492185368038375211941297871289403061486510064429072584259746910423138674192557")
        );
    }

    @Override
    public InetSocketAddress Resolve() throws Exception {
        return new InetSocketAddress("localhost", 13516);
    }
}
