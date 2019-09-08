package helpers;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkHelper {

    private final static List<Integer> PORT_TO_LISTENER = Arrays.asList(new Integer[]{9000, 9001, 9002, 9003, 9004, 9005, 9006, 9007, 9008, 9009});

    public static List<Integer> getPortsToListerner(){
        return PORT_TO_LISTENER.stream()
                                    .filter(x -> verifyIsPortAvailable(x))
                                        .collect(Collectors.toList());
    }

    private static boolean verifyIsPortAvailable(Integer port){
        try (Socket available = new Socket("localhost", port)) {
            available.close();
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }

}
