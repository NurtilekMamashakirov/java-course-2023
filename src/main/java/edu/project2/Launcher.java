package edu.project2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Launcher {

    private final static Logger LOGGER = LogManager.getLogger();

    private Launcher() {
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IdealMazeSolver mazeSolver = new IdealMazeSolver();
        int height;
        int width;

        final int maxHeight = 75;
        final int maxWidth = 120;
        do {
            LOGGER.info("Input height (75 > height > 1) and width (120 > width > 1) of maze.");
            //такие ограничения, тк слишком большие лабиринты обрезаются на моем пк. Пока не нашел, как пофиксить(
            height = scanner.nextInt();
            width = scanner.nextInt();
        } while (height >= maxHeight || height <= 1 || width >= maxWidth || width <= 1);
        Maze maze = new IdealMazeGenerator().generate(height, width);
        MazeRenderer mazeRenderer = new MazeRenderer();
        mazeRenderer.render(maze);
        int x1;
        int y1;
        do {
            LOGGER.info("Input start coordinate (width > x >= 0 and height > y >= 0)");
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
        } while (x1 >= width || x1 < 0 || y1 >= height || y1 < 0);
        int x2;
        int y2;
        do {
            LOGGER.info("Input end coordinate (width > x >= 0 and height > y >= 0)");
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
        } while (x2 >= width || x2 < 0 || y2 >= height || y2 < 0);
        List<Coordinate> path = mazeSolver.solve(maze, new Coordinate(x1, y1), new Coordinate(x2, y2));
        mazeRenderer.render(maze, path);
    }
}
