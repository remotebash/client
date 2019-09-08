package application;

import com.sun.jna.Platform;
import communication.SocketCommunication;
import helpers.ComputerHelper;
import helpers.Initialize;
import io.PromptIO;
import modal.Command;

import java.util.Date;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Initialize.start();


     //   SocketCommunication socketCommunication = new SocketCommunication();
     //   socketCommunication.listenPort(9077);

        /*SocketCommunication socketCommunication = new SocketCommunication();
        Scanner in = new Scanner(System.in);
        if(socketCommunication.start()){
          while(true){
              System.out.println("remotebash > ");
              Command command = new Command("windows", in.nextLine(), new Date());
              String ret = socketCommunication.sendCommand(command);
              System.out.println(ret);
          }

       }*/

       /* System.out.println("remotebash > ");
        Command cmd = new Command("windows", new Scanner(System.in).next(), new Date());
        new PromptIO().exec(cmd);
        */
    }
}
