package helpers;

import communication.SocketCommunication;

import java.util.List;

public class Initialize {

    public static void start() {
        System.out.println("-- load data --");
        load();
        System.out.println("-- listen ports --");
        listenPorts();
    }

    private static void load() {
        ComputerHelper.getComputer();
    }

    private static void listenPorts() {
        List<Integer> ports = NetworkHelper.getPortsToListerner();
        SocketCommunication socketCommunication = new SocketCommunication();
        for (Integer port : ports) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    socketCommunication.listenPort(port);
                }
            }).start();
        }
    }

}
