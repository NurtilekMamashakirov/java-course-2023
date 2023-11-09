package edu.project2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.util.List;

public class MazeRenderer implements Renderer {

    private final static int LENGTH_OF_LINE = 10;
    private final static int FRAME_WIDTH_AND_HEIGHT = 2000;

    @Override
    public void render(Maze maze) {
        List<List<Cell>> mazeField = maze.getMaze();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawLine(0, 0, mazeField.get(0).size() * LENGTH_OF_LINE, 0);
                g.drawLine(
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    0,
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    mazeField.size() * LENGTH_OF_LINE
                );
                g.drawLine(
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    mazeField.size() * LENGTH_OF_LINE,
                    0,
                    mazeField.size() * LENGTH_OF_LINE
                );
                g.drawLine(0, mazeField.size() * LENGTH_OF_LINE, 0, 0);

                for (List<Cell> cells : mazeField) {
                    for (Cell cell : cells) {
                        if (cell.getRightEdge()) {
                            g.drawLine(
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE,
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE
                            );
                        }
                        if (cell.getDownEdge()) {
                            g.drawLine(
                                cell.getCol() * LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE
                            );
                        }
                    }
                }
            }
        };
        frame.add(panel);
        frame.setSize(FRAME_WIDTH_AND_HEIGHT, FRAME_WIDTH_AND_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void render(Maze maze, List<Coordinate> path) {
        List<List<Cell>> mazeField = maze.getMaze();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawLine(0, 0, mazeField.get(0).size() * LENGTH_OF_LINE, 0);
                g.drawLine(
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    0,
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    mazeField.size() * LENGTH_OF_LINE
                );
                g.drawLine(
                    mazeField.get(0).size() * LENGTH_OF_LINE,
                    mazeField.size() * LENGTH_OF_LINE,
                    0,
                    mazeField.size() * LENGTH_OF_LINE
                );
                g.drawLine(0, mazeField.size() * LENGTH_OF_LINE, 0, 0);

                for (List<Cell> cells : mazeField) {
                    for (Cell cell : cells) {
                        if (cell.getRightEdge()) {
                            g.drawLine(
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE,
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE
                            );
                        }
                        if (cell.getDownEdge()) {
                            g.drawLine(
                                cell.getCol() * LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getCol() * LENGTH_OF_LINE + LENGTH_OF_LINE,
                                cell.getRow() * LENGTH_OF_LINE + LENGTH_OF_LINE
                            );
                        }
                    }
                }
                final int NUMBER_TO_CENTER = 2;
                final int ROUND_RADIUS = 5;
                for (Coordinate coordinate : path) {
                    g.drawOval(
                        coordinate.col() * LENGTH_OF_LINE + NUMBER_TO_CENTER,
                        coordinate.row() * LENGTH_OF_LINE + NUMBER_TO_CENTER,
                        ROUND_RADIUS,
                        ROUND_RADIUS
                    );
                }
            }
        };
        frame.add(panel);
        frame.setSize(FRAME_WIDTH_AND_HEIGHT, FRAME_WIDTH_AND_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
