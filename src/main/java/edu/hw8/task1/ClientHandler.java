package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final static InsultDictionary INSULT_DICTIONARY = new InsultDictionary();
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        inputStream = clientSocket.getInputStream();
        outputStream = clientSocket.getOutputStream();
    }

    @Override
    public void run() {
        String theme = readRequest();
        String insult = INSULT_DICTIONARY.getInsult(theme);
        System.out.println(insult);
        write();
    }

    private void write() {
        try (PrintWriter writer = new PrintWriter(outputStream)) {
            writer.write("lol");
        }
    }

    private String readRequest() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
