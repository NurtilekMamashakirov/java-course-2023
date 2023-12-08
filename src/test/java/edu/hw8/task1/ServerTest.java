package edu.hw8.task1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import static org.assertj.core.api.Assertions.assertThat;

public class ServerTest {

    static Server server = new Server();

    @BeforeAll
    static void startServer() {
        server.start();
    }

    @Test
    void test() throws IOException {
        try (Socket socket = new Socket(InetAddress.getByName("localHost"), 18080);
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.println("глупый");
            String insult = reader.readLine();
            assertThat(insult).isEqualTo(
                "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        }
    }

    @AfterAll
    static void stopServer() {
        server.stopServer();
    }
}
