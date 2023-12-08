package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final static InsultDictionary INSULT_DICTIONARY = new InsultDictionary();
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream())), true);
    }

    @Override
    public void run() {
        String theme = readRequest();
        String insult = INSULT_DICTIONARY.getInsult(theme);
        writer.println(insult);
    }

    public String readRequest() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
