package edu.project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazeRenderer implements Renderer {

    @Override
    public void render(Maze maze) {
        List<List<Cell>> mazeField = maze.getMaze();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.drawLine(0, 0, mazeField.get(0).size() * 10, 0);
                g.drawLine(mazeField.get(0).size() * 10, 0, mazeField.get(0).size() * 10, mazeField.size() * 10);
                g.drawLine(mazeField.get(0).size() * 10, mazeField.size() * 10, 0, mazeField.size() * 10);
                g.drawLine(0, mazeField.size() * 10, 0, 0);

                for (List<Cell> cells : mazeField) {
                    for (Cell cell : cells) {
                        if (cell.getRightEdge()) {
                            g.drawLine(
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10,
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10 + 10
                            );
                        }
                        if (cell.getDownEdge()) {
                            g.drawLine(
                                cell.getCol() * 10,
                                cell.getRow() * 10 + 10,
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10 + 10
                            );
                        }
                    }
                }
            }
        };
        frame.add(panel);
        frame.setSize(2000, 2000);
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

                g.drawLine(0, 0, mazeField.get(0).size() * 10, 0);
                g.drawLine(mazeField.get(0).size() * 10, 0, mazeField.get(0).size() * 10, mazeField.size() * 10);
                g.drawLine(mazeField.get(0).size() * 10, mazeField.size() * 10, 0, mazeField.size() * 10);
                g.drawLine(0, mazeField.size() * 10, 0, 0);

                for (List<Cell> cells : mazeField) {
                    for (Cell cell : cells) {
                        if (cell.getRightEdge()) {
                            g.drawLine(
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10,
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10 + 10
                            );
                        }
                        if (cell.getDownEdge()) {
                            g.drawLine(
                                cell.getCol() * 10,
                                cell.getRow() * 10 + 10,
                                cell.getCol() * 10 + 10,
                                cell.getRow() * 10 + 10
                            );
                        }
                    }
                }
                for (Coordinate coordinate: path) {
                    g.drawOval(coordinate.col() * 10 + 2, coordinate.row() * 10 + 2, 5, 5);
                }
            }
        };
        frame.add(panel);
        frame.setSize(2000, 2000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
