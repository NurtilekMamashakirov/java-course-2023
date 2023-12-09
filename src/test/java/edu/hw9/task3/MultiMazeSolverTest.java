package edu.hw9.task3;

import edu.project2.Coordinate;
import edu.project2.Generator;
import edu.project2.IdealMazeGenerator;
import edu.project2.IdealMazeSolver;
import edu.project2.Maze;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiMazeSolverTest {

    private static final Coordinate START = new Coordinate(10, 10);
    private static final Coordinate END = new Coordinate(40, 40);

    @Test
    void solveTest() {
        Generator mazeGenerator = new IdealMazeGenerator();
        Maze maze = mazeGenerator.generate(50, 50);
        IdealMazeSolver idealMazeSolver = new IdealMazeSolver();
        List<Coordinate> expected = idealMazeSolver.solve(maze,
            START,
            END
        ); //немного говно-тест, но с другой стороны я ж чекал IdealMazeSolver в проекте и уверен в нем)))
        MultiMazeSolver multiMazeSolver = new MultiMazeSolver();
        List<Coordinate> actual = multiMazeSolver.solve(maze, START, END);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}
