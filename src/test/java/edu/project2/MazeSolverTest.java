package edu.project2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeSolverTest {

    @Test
    void solverTest() {
        IdealMazeSolver mazeSolver = new IdealMazeSolver();
        List<List<Cell>> mazeField = new ArrayList<>();
        List<Cell> cells1 = new ArrayList<>();
        List<Cell> cells2 = new ArrayList<>();

        Cell cell1 = new Cell(0, 0);
        cell1.setDownEdge(false);
        Cell cell2 = new Cell(0, 1);
        cell2.setDownEdge(false);
        cells1.add(cell1);
        cells1.add(cell2);

        Cell cell3 = new Cell(1, 0);
        cell3.setRightEdge(false);
        Cell cell4 = new Cell(1, 1);
        cells2.add(cell3);
        cells2.add(cell4);

        mazeField.add(cells1);
        mazeField.add(cells2);
        Maze maze = new Maze(mazeField);

        List<Coordinate> expectedPath = new ArrayList<>();
        expectedPath.add(new Coordinate(0, 1));
        expectedPath.add(new Coordinate(0, 0));
        expectedPath.add(new Coordinate(1, 1));
        expectedPath.add(new Coordinate(1, 0));
        Set<Coordinate> expectedPathSet = new HashSet<>(expectedPath);
        Set<Coordinate> actualPathSet = new HashSet<>(mazeSolver.solve(maze, new Coordinate(0, 0), new Coordinate(0, 1)));
        assertThat(actualPathSet).isEqualTo(expectedPathSet);
    }
    //Пока не нашел способ, как проверить вывод лабиринта, тк делал через swing
}
