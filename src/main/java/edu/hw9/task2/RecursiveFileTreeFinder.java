package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class RecursiveFileTreeFinder extends RecursiveTask<List<Path>> {

    private Path currentDirectory;
    private Predicate<Path> predicate;

    public RecursiveFileTreeFinder(Path currentDirectory, Predicate<Path> predicate) {
        this.currentDirectory = currentDirectory;
        this.predicate = predicate;
    }

    @Override
    protected List<Path> compute() {
        List<Path> paths = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentDirectory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path) && predicate.test(path)) {
                    paths.add(path);
                }
                if (Files.isDirectory(path)) {
                    RecursiveFileTreeFinder treeFinder = new RecursiveFileTreeFinder(path, predicate);
                    treeFinder.fork();
                    paths.addAll(treeFinder.invoke());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return paths;
    }

}
