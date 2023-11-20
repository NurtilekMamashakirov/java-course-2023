package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortChecker {

    private PortChecker() {
    }

    private final static int PORT_MAX = 49151;
    private final static String HOST_NAME = "localhost";
    private final static String FOR_BUSY_PORT = "\tClosed";
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String TCP_PORT = "TCP";
    private final static String UDP_PORT = "UDP";

    public static void scanPorts() {
        LOGGER.info("Протокол\tПорт\tСервис");
        for (int port = 0; port < PORT_MAX; port++) {
            checkPort(port, TCP_PORT);
            checkPort(port, UDP_PORT);
        }
    }

    private static void checkPort(int port, String protocol) {
        switch (protocol) {
            case TCP_PORT -> {
                try (Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(HOST_NAME, port));
                } catch (IOException e) {
                    LOGGER.info(protocol + "\t" + port + FOR_BUSY_PORT);
                }
            }
            case UDP_PORT -> {
                try (DatagramSocket socket = new DatagramSocket()) {
                    socket.connect(new InetSocketAddress(HOST_NAME, port));
                    LOGGER.info(protocol + "\t" + port + "\t" + getServiceName(port));
                } catch (SocketException e) {
                    LOGGER.info(protocol + "\t" + port + FOR_BUSY_PORT);
                }
            }
            default -> {
            }

        }
    }

    private static String getServiceName(int port) {
        PortsNames portsNames = new PortsNames();
        Map<Integer, String> dictionary = portsNames.getDictionary();
        if (dictionary.get(port) == null) {
            return "";
        } else {
            return dictionary.get(port);
        }
    }

}
