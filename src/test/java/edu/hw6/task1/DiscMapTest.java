package edu.hw6.task1;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscMapTest {

    @Test
    void containsKeyTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Hello", "world");
        assertThat(diskMap.containsKey("Hello")).isTrue();
        diskMap.clear();
    }

    @Test
    void isEmptyTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.clear();
        assertThat(diskMap.isEmpty()).isTrue();
    }

    @Test
    void containsValueTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Hello", "world");
        assertThat(diskMap.containsValue("world")).isTrue();
        diskMap.clear();
    }

    @Test
    void getTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Hello", "world");
        assertThat(diskMap.get("Hello")).isEqualTo("world");
        diskMap.clear();
    }

    @Test
    void putTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Hello", "world");
        assertThat(diskMap.containsKey("Hello")).isTrue();
        diskMap.clear();
    }

    @Test
    void removeTest() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Hello", "world");
        diskMap.remove("Hello");
        assertThat(diskMap.get("Hello")).isNull();
        diskMap.clear();
    }

    @Test
    void putAllTest() {
        DiskMap diskMap = new DiskMap();
        Map<String, String> map = new HashMap<>();
        map.put("Hello", "world");
        map.put("Hi", "Earth");
        diskMap.putAll(map);
        assertThat(diskMap.containsKey("Hello") && diskMap.containsKey("Hi")).isTrue();
        diskMap.clear();
    }

}
