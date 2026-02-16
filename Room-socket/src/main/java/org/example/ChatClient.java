package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

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

            System.out.print("Enter your name: ");
            String userName = userInput.readLine();
            serverOut.println(userName);

            // Receive thread
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = serverIn.readLine()) != null) {
                        JSONObject json = new JSONObject(msg);
                        System.out.println(json.getString("sender") +
                                " : " + json.getString("message"));
                    }
                } catch (Exception e) {}
            }).start();

            while (true) {
                System.out.println("1. Join Room");
                System.out.println("2. Send Message");

                String choice = userInput.readLine();

                if (choice.equals("1")) {
                    System.out.print("Enter Room ID: ");
                    String roomId = userInput.readLine();

                    JSONObject json = new JSONObject();
                    json.put("type", "JOIN");
                    json.put("roomId", roomId);
                    serverOut.println(json.toString());
                }

                if (choice.equals("2")) {
                    System.out.print("Room ID: ");
                    String roomId = userInput.readLine();

                    System.out.print("Message: ");
                    String content = userInput.readLine();

                    JSONObject json = new JSONObject();
                    json.put("type", "MESSAGE");
                    json.put("roomId", roomId);
                    json.put("content", content);

                    serverOut.println(json.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
