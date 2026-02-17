package org.example;

import java.io.*;
import java.net.Socket;

 class HelloClient {
     public static void main(String[] args) throws IOException {
         Socket socket = new Socket("localhost",5000);

         BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
         );

         PrintWriter out = new PrintWriter(
                 socket.getOutputStream(), true
         );

         out.println("Dhruv");
         while(in.readLine()!=null){

         }


    }
}
