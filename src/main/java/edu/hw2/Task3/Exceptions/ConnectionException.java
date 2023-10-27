package edu.hw2.Task3.Exceptions;

import edu.hw2.Task3.Connections.Connection;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super();
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
