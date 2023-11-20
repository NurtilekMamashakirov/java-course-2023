package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Composition {

    private Composition() {
    }

    private final static String MESSAGE_TO_WRITE = "Programming is learned by writing programs. ― Brian Kernighan";

    public static void compose(String fileName) {
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(fileName))) {
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                bufferedOutputStream,
                StandardCharsets.UTF_8
            );
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            printWriter.write(MESSAGE_TO_WRITE);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
