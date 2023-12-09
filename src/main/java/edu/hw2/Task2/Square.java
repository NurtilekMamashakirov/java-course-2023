package edu.hw2.Task2;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(Integer width) {
        super(width, width);
    }

    @Override
    public Rectangle setWidth(Integer width) {
        return new Square(width);
    }

    @Override
    public Rectangle setHeight(Integer height) {
        return new Square(height);
    }

}
