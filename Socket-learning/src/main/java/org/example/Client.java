package org.example;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {

        try {
            // 1. Connect to server
            Socket socket = new Socket("localhost", 5000);

            // 2. Output to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // 3. Input from server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // 4. Send message
            out.println("Hello Server!");

            // 5. Read reply
            String reply = in.readLine();
            System.out.println("Server says: " + reply);

            // 6. Close
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}