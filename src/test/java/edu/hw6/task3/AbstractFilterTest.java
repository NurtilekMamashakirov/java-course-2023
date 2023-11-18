package edu.hw6.task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.hw6.task3.AbstractFilter.globMatches;
import static edu.hw6.task3.AbstractFilter.largerThan;
import static edu.hw6.task3.AbstractFilter.magicNumber;
import static edu.hw6.task3.AbstractFilter.regexContains;

public class AbstractFilterTest {

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;

    @Test
    void test() {

        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(100))
            .and(globMatches("*.pdf"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(
            "/Users/nurtilekm/Desktop/Презентации по лекцимя тинькофф"), filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
