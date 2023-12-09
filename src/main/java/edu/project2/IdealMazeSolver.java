package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class IdealMazeSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<List<Cell>> mazeField = maze.getMaze();
        int height = mazeField.size();
        int width = mazeField.get(0).size();
        List<Coordinate> path = new ArrayList<>();
        path.add(start);
        Queue<Cell> cellQueue = new ArrayDeque<>();
        cellQueue.offer(mazeField.get(start.row()).get(start.col()));
        boolean[][] checkForIn = new boolean[height][width];
        checkForIn[start.row()][start.col()] = true;
        while (cellQueue.size() > 0) {
            Cell actualCell = cellQueue.poll();
            Cell rightCell;
            Cell downCell;
            Cell leftCell;
            Cell upCell;
            if (!actualCell.getRightEdge() && actualCell.getCol() != width - 1
                && !checkForIn[actualCell.getRow()][actualCell.getCol() + 1]) {
                rightCell = mazeField.get(actualCell.getRow()).get(actualCell.getCol() + 1);
                rightCell.setParentCell(actualCell);
                cellQueue.offer(rightCell);
                checkForIn[rightCell.getRow()][rightCell.getCol()] = true;
                List<Cell> stringMazeField = mazeField.get(rightCell.getRow());
                stringMazeField.set(rightCell.getCol(), rightCell);
                mazeField.set(rightCell.getRow(), stringMazeField);
            }
            if (!actualCell.getDownEdge() && actualCell.getRow() != height - 1
                && !checkForIn[actualCell.getRow() + 1][actualCell.getCol()]) {
                downCell = mazeField.get(actualCell.getRow() + 1).get(actualCell.getCol());
                downCell.setParentCell(actualCell);
                cellQueue.offer(downCell);
                checkForIn[downCell.getRow()][downCell.getCol()] = true;
                List<Cell> stringMazeField = mazeField.get(downCell.getRow());
                stringMazeField.set(downCell.getCol(), downCell);
                mazeField.set(downCell.getRow(), stringMazeField);
            }
            if (actualCell.getCol() != 0
                && !mazeField.get(actualCell.getRow()).get(actualCell.getCol() - 1).getRightEdge()
                && !checkForIn[actualCell.getRow()][actualCell.getCol() - 1]) {
                leftCell = mazeField.get(actualCell.getRow()).get(actualCell.getCol() - 1);
                leftCell.setParentCell(actualCell);
                cellQueue.offer(leftCell);
                checkForIn[leftCell.getRow()][leftCell.getCol()] = true;
                List<Cell> stringMazeField = mazeField.get(leftCell.getRow());
                stringMazeField.set(leftCell.getCol(), leftCell);
                mazeField.set(leftCell.getRow(), stringMazeField);
            }
            if (actualCell.getRow() != 0
                && !mazeField.get(actualCell.getRow() - 1).get(actualCell.getCol()).getDownEdge()
                && !checkForIn[actualCell.getRow() - 1][actualCell.getCol()]) {
                upCell = mazeField.get(actualCell.getRow() - 1).get(actualCell.getCol());
                upCell.setParentCell(actualCell);
                cellQueue.offer(upCell);
                checkForIn[upCell.getRow()][upCell.getCol()] = true;
                List<Cell> stringMazeField = mazeField.get(upCell.getRow());
                stringMazeField.set(upCell.getCol(), upCell);
                mazeField.set(upCell.getRow(), stringMazeField);
            }
        }

        Cell actualCell = mazeField.get(end.row()).get(end.col());

        while (!actualCell.equals(mazeField.get(start.row()).get(start.col()))) {
            path.add(new Coordinate(actualCell.getRow(), actualCell.getCol()));
            actualCell = actualCell.getParentCell();
        }

        return path;
    }

}
