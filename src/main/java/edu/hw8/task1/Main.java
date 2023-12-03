package edu.hw8.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();
        server.join();
    }
}

class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.start();
        client.join();
    }

}
