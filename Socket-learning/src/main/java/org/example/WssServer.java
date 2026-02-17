package org.example;

import org.glassfish.tyrus.server.Server;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;

public class WssServer {

    public static void main(String[] args) throws Exception {

        char[] password = "password".toCharArray();

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("keystore.jks"), password);

        KeyManagerFactory kmf =
                KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, password);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        Server server = new Server(
                "localhost",
                8443,
                "/",
                (Map<String, Object>) sslContext,
                WebsocketChatEndpoint.class
        );

        server.start();

        System.out.println("Secure WebSocket server started at:");
        System.out.println("wss://localhost:8443/chat");

        Thread.currentThread().join();
    }
}
