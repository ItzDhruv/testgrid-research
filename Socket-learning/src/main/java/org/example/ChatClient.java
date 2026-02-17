package org.example;

import java.io.*;
import java.net.*;

public class ChatClient {

    String userName;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader serverIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter serverOut = new PrintWriter(
                    socket.getOutputStream(), true
            );

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            System.out.print("Enter Your name : ");
            String userName = userInput.readLine();

            serverOut.println(userName);

            // Thread to receive messages
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = serverIn.readLine()) != null) {
                        System.out.println(msg);
                        System.out.println("Thread running");
                    }
                } catch (Exception e) {}
            }).start();

            // Send messages
            String message;
            while (true) {
                message = userInput.readLine();
                serverOut.println(message);
                System.out.println("Infinite loop running");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}