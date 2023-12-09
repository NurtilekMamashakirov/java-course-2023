package edu.hw2.Task2;

public class Rectangle {
    private final Integer width;
    private final Integer height;

    public Rectangle() {
        width = 0;
        height = 0;
    }

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(Integer width) {
        return new Rectangle(width, this.height);
    }

    public Rectangle setHeight(Integer height) {
        return new Rectangle(this.width, height);
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }
}
