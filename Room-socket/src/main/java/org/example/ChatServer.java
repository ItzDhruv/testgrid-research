package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
