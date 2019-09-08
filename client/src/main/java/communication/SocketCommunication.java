package communication;

import com.google.gson.Gson;
import helpers.NetworkHelper;
import io.PromptIO;
import modal.Command;
import oshi.PlatformEnum;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SocketCommunication {

    private final static String HOST = "0000";
    private final static int PORT_HOST = 9077;

    private NetworkHelper networkHelper;
    private PromptIO prompt;

    public SocketCommunication() {
        networkHelper = new NetworkHelper();
    }

    public boolean start() {
        return sendTextToHost("start communication").toLowerCase().equals("connection established");
    }

    private String sendTextToHost(String text) {
        try (Socket socket = new Socket(HOST, PORT_HOST)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(text);

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            return reader.readLine();

        } catch (UnknownHostException ex) {
            return String.format("Server not found: %1$s", ex.getMessage());
        } catch (IOException ex) {
            return String.format("I/O error: %1$s", ex.getMessage());
        }
    }

    public void listenPort(int port) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port,0, InetAddress.getLocalHost())) {
                System.out.println("Server is listening on port " +port);

                Socket socket = serverSocket.accept();

                System.out.println(String.format("new client connected in port %1$d", port));

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line = reader.readLine();

                if (line.toLowerCase().equals("start communication")) {
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("connection established");
                    socket.close();
                } else {
                    Gson gson = new Gson();

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    Command commandObj = new Command(PlatformEnum.WINDOWS, line, new Date(), "carlinhos");
                    Command command = execCommand(commandObj);
                    writer.println(gson.toJson(command));
                }

            } catch (IOException ex) {
                System.out.println(String.format("Server exception: %1$s", ex.getMessage()));
                ex.printStackTrace();
            }
        }
    }

    private Command execCommand(Command command) {
        prompt = new PromptIO();
        return prompt.exec(command);
    }
}
