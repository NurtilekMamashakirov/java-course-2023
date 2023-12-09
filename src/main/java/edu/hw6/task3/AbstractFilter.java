package edu.hw6.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter nextFilter) {
        return entry -> accept(entry) && nextFilter.accept(entry);
    }

    static AbstractFilter isReadable() {
        return Files::isReadable;
    }

    static AbstractFilter isWritable() {
        return Files::isWritable;
    }

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }


    static AbstractFilter extensionFilter(String extension) {
        return entry -> extension.equals(FilenameUtils.getExtension(entry.toString()));
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> {
            PathMatcher matcher =
                entry.getParent().getFileSystem().getPathMatcher("glob:" + glob);
            return matcher.matches(entry.getFileName());
        };
    }

    static AbstractFilter magicNumber(int... magicNumbers) {
        return entry -> {
            File file = entry.toFile();
            try (InputStream inputStream = new FileInputStream(file)) {
                for (int magicNumber : magicNumbers) {
                    if (inputStream.read() != magicNumber) {
                        return false;
                    }
                }
            } catch (IOException e) {
                return false;
            }
            return true;
        };
    }

    static AbstractFilter regexContains(String regex) {
        return entry -> Pattern.compile(regex).matcher(entry.toString()).find();
    }

}
