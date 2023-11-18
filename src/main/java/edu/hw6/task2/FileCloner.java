package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCloner {

    public static void cloneFile(Path path) {
        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("It isn't regular file!");
        }

        String fileName = path.getFileName().toString().split("\\.")[0];
        String fileExtension = path.getFileName().toString().split("\\.")[1];
        String regex = "^" + fileName + "( - копия( \\(\\d+\\))?)?\\." + fileExtension + "$";
        Pattern pattern = Pattern.compile(regex);
        int countCopiesOfFileInDirectory = 0;
        Path directoryPath = getDirectoryPath(path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Matcher matcher = pattern.matcher(file.getFileName().toString());
                    if (matcher.matches()) {
                        countCopiesOfFileInDirectory++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String copyName = "";
        if (countCopiesOfFileInDirectory == 1) {
            copyName =
                path.toString().substring(0, path.toString().lastIndexOf("/") + 1) + fileName
                    + " - копия." + fileExtension;
        } else if (countCopiesOfFileInDirectory > 1) {
            copyName =
                path.toString().substring(0, path.toString().lastIndexOf("/") + 1) + fileName
                    + " - копия (" + countCopiesOfFileInDirectory + ")." + fileExtension;
        }
        Path copyPath = Paths.get(copyName);
        try {
            Files.copy(path, copyPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getDirectoryPath(Path filePath) {
        StringBuilder buildDirectoryPath = new StringBuilder();
        int pathSize = filePath.getNameCount();
        for (int i = 0; i < pathSize - 1; i++) {
            buildDirectoryPath.append("/")
                .append(filePath.getName(i));
        }
        String stringDirectoryPath = buildDirectoryPath.toString();
        return Paths.get(stringDirectoryPath);
    }
}
