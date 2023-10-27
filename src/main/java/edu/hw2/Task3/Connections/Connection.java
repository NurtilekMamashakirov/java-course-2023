package edu.hw2.Task3.Connections;

public interface Connection extends AutoCloseable{
    void execute(String command);
}
