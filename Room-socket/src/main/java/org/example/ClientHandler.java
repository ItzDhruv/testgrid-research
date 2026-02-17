package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    String userName;
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            this.userName = in.readLine();
            ChatServer.users.put(userName, this);

            System.out.println(userName + " connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String input;

            while ((input = in.readLine()) != null) {

                if (input.startsWith("JOIN:")) {
                    String roomId = input.split(":")[1];

                    ChatServer.rooms.putIfAbsent(roomId, new Room(roomId));
                    ChatServer.rooms.get(roomId).join(this);

                    out.println("Joined room " + roomId);
                }

                else if (input.startsWith("MSG:")) {
                    String[] parts = input.split(":", 3);
                    String roomId = parts[1];
                    String content = parts[2];

                    Room room = ChatServer.rooms.get(roomId);
                    if (room != null) {
                        room.broadcast(userName, content);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(userName + " disconnected");
        }
    }

    public void sendMessage(String sender, String msg) {
        JSONObject json = new JSONObject();
        json.put("sender", sender);
        json.put("message", msg);
        out.println(json.toString());
    }
}