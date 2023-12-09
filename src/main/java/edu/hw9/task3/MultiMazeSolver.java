package edu.hw9.task3;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Solver;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MultiMazeSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Cell startCell = maze.getMaze().get(start.row()).get(start.col());
        Cell endCell = maze.getMaze().get(end.row()).get(end.col());
        RecursiveSolver recursiveSolver = new RecursiveSolver(null, startCell, endCell, maze.getMaze());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(recursiveSolver);
    }

}
