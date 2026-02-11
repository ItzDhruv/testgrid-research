package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

 class HelloClient {
     public static void main(String[] args) throws IOException {
         Socket socket = new Socket("localhost",5000);
         PrintWriter out = new PrintWriter(
                 socket.getOutputStream(), true
         );
         out.println("Dhruv");

    }
}
