package org.example.room;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {

    static Map<String, ClientHandler> users = new ConcurrentHashMap<>();
    static Map<String, Room> rooms = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Chat Server started on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);
                new Thread(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
