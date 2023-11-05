package edu.project2;

import java.util.List;

public final class Maze {

    private List<List<Cell>> maze;

    public List<List<Cell>> getMaze() {
        return maze;
    }

    public Maze(List<List<Cell>> maze) {
        this.maze = maze;
    }




    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maze maze1 = (Maze) o;

        return maze != null ? maze.equals(maze1.maze) : maze1.maze == null;
    }

    @Override
    public int hashCode() {
        return maze != null ? maze.hashCode() : 0;
    }
}
