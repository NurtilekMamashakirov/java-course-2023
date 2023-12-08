package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client extends Thread {

    private static final Logger LOGGER = LogManager.getLogger();
    private final static String HOST = "localhost";
    private final static int PORT = 18080;

    @Override
    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName(HOST), PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(
                 new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
                 true);
             Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Введите тему для унижений");
            writer.println(scanner.next());
            String insult = reader.readLine();
            LOGGER.info(insult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
