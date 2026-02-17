package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    // store all connected clients
    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Chat Server started on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(" New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                new Thread(client).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // send message to all clients
    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(sender.userName, message);
            }
        }
    }
}

class ClientHandler implements Runnable {
            String userName;
            Socket socket;
            BufferedReader in;
            PrintWriter out;

    ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            this.userName = in.readLine();
            System.out.println("Welcome to the chat : "+userName);
            ChatServer.broadcast(userName + " joined - the chat", this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(userName +" message: " + message);
                ChatServer.broadcast(message, this);
            }
        } catch (Exception e) {
            System.out.println(" Client disconnected");
        }
    }

    void sendMessage(String user_name,String msg) {
        out.println("("+user_name+") : "+msg);
    }
}