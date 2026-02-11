package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 class Server {

    public static void main(String[] args) throws IOException {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client");

            Socket socket = serverSocket.accept();
            System.out.println("client accepted");


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );



            String msg = in.readLine();
            System.out.println("Client says: " + msg);

            // 6. Send reply
            out.println("Hello from Server!");

            // 7. Close
            socket.close();
            serverSocket.close();



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }

}
