package edu.hw6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {

    private final Path PATH_TO_FILE =
        Paths.get("/Users/nurtilekm/IdeaProjects/java-course-2023/src/main/java/edu/hw6/task1/DiscMapFile.txt");
    private Integer size = defineSize();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean checkForContains = false;
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            for (String line : lines) {
                if (line.split(":")[0].equals(key)) {
                    checkForContains = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkForContains;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean checkForContains = false;
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            for (String line : lines) {
                if (line.split(":")[1].equals(value)) {
                    checkForContains = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkForContains;
    }

    @Override
    public String get(Object key) {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            for (String line : lines) {
                if (line.split(":")[0].equals(key)) {
                    return line.split(":")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            String previousValue = get(key);
            if (containsKey(key)) {
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).split(":")[0].equals(key)) {
                        lines.set(i, key + ":" + value);
                    }
                }
            } else {
                lines.add(key + ":" + value);
                size++;
            }
            Files.write(PATH_TO_FILE, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return previousValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String remove(Object key) {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            String previousValue = get(key);
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).split(":")[0].equals(key)) {
                    lines.remove(i);
                    size--;
                }
            }
            Files.write(PATH_TO_FILE, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return previousValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        m.forEach(this::put);
        size = defineSize();
    }

    @Override
    public void clear() {
        try {
            Files.write(
                PATH_TO_FILE,
                new ArrayList<>(),
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        size = 0;
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            return lines.stream().map(line -> line.split(":")[0]).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            return lines.stream().map(line -> line.split(":")[1]).collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            Map<String, String> map = lines.stream()
                .collect(Collectors.toMap(line -> line.split(":")[0]
                    , line -> line.split(":")[1]));
            return map.entrySet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Integer defineSize() {
        try {
            List<String> lines = Files.readAllLines(PATH_TO_FILE);
            return lines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
