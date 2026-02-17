package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
   static int counter =0;
    public static void main(String[] args)  throws IOException{

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client");

        while(true){
            Socket socket = serverSocket.accept();
            ++counter;
            System.out.println("New client meetup : "+counter);
            BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = in.readLine();
            System.out.println("message is :" +msg);
        }
    }

}