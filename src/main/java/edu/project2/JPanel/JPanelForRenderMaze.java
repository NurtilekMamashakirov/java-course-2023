package edu.project2.JPanel;

import edu.project2.Cell;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class JPanelForRenderMaze extends JPanel {

    private final static int LENGTH_OF_LINE = 10;
    private final List<List<Cell>> mazeField;

    public JPanelForRenderMaze(List<List<Cell>> mazeField) {
        this.mazeField = mazeField;
    }

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
}
