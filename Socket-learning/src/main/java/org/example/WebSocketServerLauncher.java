package org.example;

import org.glassfish.tyrus.server.Server;


public class WebSocketServerLauncher {



    public static void main(String[] args) throws Exception {

        Server server = new Server(
                "localhost",
                8080,
                "/",
                null,
                WebsocketChatEndpoint.class
        );

        server.start();

        System.out.println("WebSocket server started at:");
        System.out.println("ws://localhost:8080/chat");

        Thread.currentThread().join();
    }
}
