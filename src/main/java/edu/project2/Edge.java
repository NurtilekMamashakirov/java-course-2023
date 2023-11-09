package edu.project2;

import java.util.Random;

public class Edge {

    private Cell cell1; //  left/up cell
    private Cell cell2;  // right/down cell
    private Integer id;

    public Edge() {
        final int numberForRandom = 1000;
        final Random random = new Random();
        id = random.nextInt(numberForRandom);
    }

    public Integer getId() {
        return id;
    }

    public Cell getCell1() {
        return cell1;
    }

    public void setCell1(Cell cell1) {
        this.cell1 = cell1;
    }

    public Cell getCell2() {
        return cell2;
    }

    public void setCell2(Cell cell2) {
        this.cell2 = cell2;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge edge = (Edge) o;

        if (cell1 != null ? !cell1.equals(edge.cell1) : edge.cell1 != null) {
            return false;
        }
        return cell2 != null ? cell2.equals(edge.cell2) : edge.cell2 == null;
    }

    @Override
    public int hashCode() {
        int result = cell1 != null ? cell1.hashCode() : 0;
        result = 31 * result + (cell2 != null ? cell2.hashCode() : 0);
        return result;
    }
}
