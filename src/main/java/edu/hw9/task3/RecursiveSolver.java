package edu.hw9.task3;

import edu.project2.Cell;
import edu.project2.Coordinate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveSolver extends RecursiveTask<List<Coordinate>> {

    private Cell previousCell;
    private Cell currentCell;
    private Cell endCell;
    private List<List<Cell>> maze;

    public RecursiveSolver(Cell previousCell, Cell currentCell, Cell endCell, List<List<Cell>> maze) {
        this.previousCell = previousCell;
        this.currentCell = currentCell;
        this.endCell = endCell;
        this.maze = maze;
    }

    @Override
    protected List<Coordinate> compute() {
        List<Coordinate> path = new ArrayList<>();
        int row = currentCell.getRow();
        int col = currentCell.getCol();
        if (currentCell.equals(endCell)) {
            path.add(new Coordinate(row, col));
            return path;
        }
        Cell leftCell = getLeftCell();
        Cell upCell = getUpCell();
        Cell rightCell = getRightCell();
        Cell downCell = getDownCell();
        if (leftCell != null && !leftCell.equals(previousCell)) {
            RecursiveSolver recursiveSolver = new RecursiveSolver(currentCell, leftCell, endCell, maze);
            recursiveSolver.fork();
            path.addAll(recursiveSolver.join());
        }
        if (upCell != null && !upCell.equals(previousCell)) {
            RecursiveSolver recursiveSolver = new RecursiveSolver(currentCell, upCell, endCell, maze);
            recursiveSolver.fork();
            path.addAll(recursiveSolver.join());
        }
        if (rightCell != null && !rightCell.equals(previousCell)) {
            RecursiveSolver recursiveSolver = new RecursiveSolver(currentCell, rightCell, endCell, maze);
            recursiveSolver.fork();
            path.addAll(recursiveSolver.join());
        }
        if (downCell != null && !downCell.equals(previousCell)) {
            RecursiveSolver recursiveSolver = new RecursiveSolver(currentCell, downCell, endCell, maze);
            recursiveSolver.fork();
            path.addAll(recursiveSolver.join());
        }
        if (!path.isEmpty()) {
            path.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
        }
        return path;
    }

    private Cell getDownCell() {
        if (!currentCell.getDownEdge()) {
            return maze.get(currentCell.getRow() + 1).get(currentCell.getCol());
        }
        return null;
    }

    private Cell getRightCell() {
        if (!currentCell.getRightEdge()) {
            return maze.get(currentCell.getRow()).get(currentCell.getCol() + 1);
        }
        return null;
    }

    private Cell getUpCell() {
        if (currentCell.getRow() != 0) {
            if (!maze.get(currentCell.getRow() - 1).get(currentCell.getCol()).getDownEdge()) {
                return maze.get(currentCell.getRow() - 1).get(currentCell.getCol());
            }
        }
        return null;
    }

    private Cell getLeftCell() {
        if (currentCell.getCol() != 0) {
            if (!maze.get(currentCell.getRow()).get(currentCell.getCol() - 1).getRightEdge()) {
                return maze.get(currentCell.getRow()).get(currentCell.getCol() - 1);
            }
        }
        return null;
    }

}
