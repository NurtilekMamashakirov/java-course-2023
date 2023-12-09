package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveFileTreeIterator extends RecursiveTask<List<Path>> {
    private Path currentDirectory;

    public RecursiveFileTreeIterator(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    protected List<Path> compute() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentDirectory)) {
            List<Path> directoriesWithMore1000Files = new ArrayList<>();
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    int filesCounter = 0;
                    try (DirectoryStream<Path> directoryStream2 = Files.newDirectoryStream(path)) {
                        for (Path path2 : directoryStream2) {
                            if (Files.isRegularFile(path2)) {
                                filesCounter++;
                            }
                        }
                    }
                    if (filesCounter > 1000) {
                        directoriesWithMore1000Files.add(path);
                    }
                    RecursiveFileTreeIterator recursiveTreeIterator = new RecursiveFileTreeIterator(path);
                    recursiveTreeIterator.fork();
                    directoriesWithMore1000Files.addAll(recursiveTreeIterator.join());
                }
            }
            return directoriesWithMore1000Files;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
