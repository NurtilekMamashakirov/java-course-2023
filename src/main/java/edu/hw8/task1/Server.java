package edu.hw8.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {

    private static final int PORT = 18080;
    private final static int MAX_CONNECTIONS = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executorService;

    public Server() {
        executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(PORT, MAX_CONNECTIONS)) {
            while (true) {
                ClientHandler clientHandler = new ClientHandler(server.accept());
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopServer() {
        Thread.currentThread().interrupt();
    }

}
