package edu.project2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cell {
    private final int row;
    private final int col;
    private Boolean rightEdge = true;
    private Boolean downEdge = true;
    private Cell parentCell; //for breadth-first search

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Cell getParentCell() {
        return parentCell;
    }

    public void setParentCell(Cell parentCell) {
        this.parentCell = parentCell;
    }

    public Boolean getRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(Boolean leftEdge) {
        this.rightEdge = leftEdge;
    }

    public Boolean getDownEdge() {
        return downEdge;
    }

    public void setDownEdge(Boolean downEdge) {
        this.downEdge = downEdge;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (row != cell.row) return false;
        return col == cell.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
