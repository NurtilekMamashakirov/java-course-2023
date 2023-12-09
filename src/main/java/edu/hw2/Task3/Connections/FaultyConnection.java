package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Exceptions.ConnectionException;

public class FaultyConnection implements Connection {

    @Override
    public void execute(String command) {
        final double NUMBER_FOR_RANDOM = 0.5;
        if (Math.random() < NUMBER_FOR_RANDOM) {
            throw new ConnectionException();
        } else {
            LOGGER.info("Connection executed successfully.");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed.");
    }

}
