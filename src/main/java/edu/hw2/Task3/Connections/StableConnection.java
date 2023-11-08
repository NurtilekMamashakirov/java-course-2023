package edu.hw2.Task3.Connections;

public class StableConnection implements Connection {

    @Override
    public void execute(String command) {
        LOGGER.info("Connection executed successfully.");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed.");
    }

}
