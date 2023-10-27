package edu.hw2.Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RectangleTest {

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Square()),
            Arguments.of(new Rectangle()),
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);
        assertEquals(rect.area(), rect.getWidth() * rect.getHeight());
    }
}
