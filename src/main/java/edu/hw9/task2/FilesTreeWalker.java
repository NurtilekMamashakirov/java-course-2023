package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesTreeWalker {

    private FilesTreeWalker() {
    }

    private static final Pattern EXTENSION_PATTERN = Pattern.compile("^\\..*$");

    public static List<Path> findDirectoriesWithMore1000Files(Path path) {
        //принимает директорию, с которой нужно начать поиск
        RecursiveFileTreeIterator recursiveTreeIterator = new RecursiveFileTreeIterator(path);
        return recursiveTreeIterator.invoke();
    }

    public static List<Path> findByFileSize(Path path, Long minSize, Long maxSize) {
        Predicate<Path> predicate = (Path file) -> {
            try {
                if (Files.size(file) > minSize && Files.size(file) < maxSize) {
                    return true;
                }
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        RecursiveFileTreeFinder finder = new RecursiveFileTreeFinder(path, predicate);
        return finder.invoke();
    }

    public static List<Path> findByFileExtension(Path path, String extension) {
        Matcher matcher = EXTENSION_PATTERN.matcher(extension);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Wrong extension format!");
        }
        Predicate<Path> predicate = (Path file) -> {
            Integer extensionStart = file.getFileName().toString().lastIndexOf(".");
            if (extensionStart == -1) {
                return false;
            }
            String fileExtension = file.getFileName().toString().substring(extensionStart);
            return extension.equalsIgnoreCase(fileExtension);
        };
        RecursiveFileTreeFinder finder = new RecursiveFileTreeFinder(path, predicate);
        return finder.invoke();
    }

}
