package edu.project4;

public class Pixel {

    private int counter;
    private int red;
    private int green;
    private int blue;

    public Pixel(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        counter = 0;
    }

    public Pixel() {
    }

    public synchronized int getRed() {
        return red;
    }

    public synchronized void setRed(int red) {
        this.red = red;
    }

    public synchronized int getGreen() {
        return green;
    }

    public synchronized void setGreen(int green) {
        this.green = green;
    }

    public synchronized int getBlue() {
        return blue;
    }

    public synchronized void setBlue(int blue) {
        this.blue = blue;
    }

    public synchronized void incrementCounter() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pixel pixel = (Pixel) o;

        if (counter != pixel.counter) {
            return false;
        }
        if (red != pixel.red) {
            return false;
        }
        if (green != pixel.green) {
            return false;
        }
        return blue == pixel.blue;
    }

    @Override
    public int hashCode() {
        int result = counter;
        result = 31 * result + red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }

    @Override public String toString() {
        return "Pixel{" +
            "counter=" + counter +
            ", red=" + red +
            ", green=" + green +
            ", blue=" + blue +
            '}';
    }

}
