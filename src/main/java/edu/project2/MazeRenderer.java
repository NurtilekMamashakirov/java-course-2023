package edu.project2;

import edu.project2.JPanel.JPanelForRenderMaze;
import edu.project2.JPanel.JPanelForRenderMazeAndSolve;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.util.List;

public class MazeRenderer implements Renderer {

    private final static int FRAME_WIDTH_AND_HEIGHT = 2000;

    @Override
    public void render(Maze maze) {
        List<List<Cell>> mazeField = maze.getMaze();
        JFrame frame = new JFrame();
        JPanel panel = new JPanelForRenderMaze(mazeField);
        frame.add(panel);
        frame.setSize(FRAME_WIDTH_AND_HEIGHT, FRAME_WIDTH_AND_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void render(Maze maze, List<Coordinate> path) {
        List<List<Cell>> mazeField = maze.getMaze();
        JFrame frame = new JFrame();
        JPanel panel = new JPanelForRenderMazeAndSolve(mazeField, path);
        frame.add(panel);
        frame.setSize(FRAME_WIDTH_AND_HEIGHT, FRAME_WIDTH_AND_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
