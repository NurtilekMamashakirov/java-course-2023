package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {

    private final static String HOST = "localhost";
    private final static int PORT = 18080;

    @Override
    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName(HOST), PORT);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream)) {
            writer.write("личности");
            int readByte;
            Thread.sleep(100);
            while ((readByte = inputStream.read()) != -1) {
                System.out.println(readByte);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
