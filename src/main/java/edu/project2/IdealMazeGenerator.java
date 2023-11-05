package edu.project2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class IdealMazeGenerator implements Generator {

    @Override
    public Maze generate(int height, int width) {

        List<List<Cell>> mazeField = new ArrayList<>();
        List<Set<Cell>> groupsOfCells = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Cell> mazeString = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                Cell thisCell = new Cell(i, j);
                mazeString.add(thisCell);
                Set<Cell> groupOfCell = new HashSet<>();
                groupOfCell.add(thisCell);
                groupsOfCells.add(groupOfCell);
            }
            mazeField.add(mazeString);
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i != height - 1 && j != width - 1) {
                    Edge edge1 = new Edge();
                    edge1.setCell1(mazeField.get(i).get(j));
                    edge1.setCell2(mazeField.get(i).get(j + 1));
                    edges.add(edge1);
                    Edge edge2 = new Edge();
                    edge2.setCell1(mazeField.get(i).get(j));
                    edge2.setCell2(mazeField.get(i + 1).get(j));
                    edges.add(edge2);
                }
                else if(i != height - 1 && j == width -1) {
                    Edge edge2 = new Edge();
                    edge2.setCell1(mazeField.get(i).get(j));
                    edge2.setCell2(mazeField.get(i + 1).get(j));
                    edges.add(edge2);
                }
                else if(i == height - 1 && j != width - 1) {
                    Edge edge1 = new Edge();
                    edge1.setCell1(mazeField.get(i).get(j));
                    edge1.setCell2(mazeField.get(i).get(j + 1));
                    edges.add(edge1);
                }

            }
        }

        edges = edges.stream().sorted(Comparator.comparing(Edge::getId)).toList();

        for (Edge edge : edges) {
            Cell cell1 = edge.getCell1();
            Cell cell2 = edge.getCell2();
            Set<Cell> cell1Group = new HashSet<>();
            Set<Cell> cell2Group = new HashSet<>();
            for (Set<Cell> groupOfCell: groupsOfCells) {
                if (groupOfCell.contains(cell1))
                    cell1Group.addAll(groupOfCell);
                if (groupOfCell.contains(cell2))
                    cell2Group.addAll(groupOfCell);
            }

            if (!cell1Group.equals(cell2Group)) {
                groupsOfCells.remove(cell1Group);
                groupsOfCells.remove(cell2Group);
                cell1Group.addAll(cell2Group);
                groupsOfCells.add(cell1Group);
                if (cell1.getRow() == cell2.getRow())
                    cell1.setRightEdge(false);
                else
                    cell1.setDownEdge(false);
            }
        }
        System.out.println(groupsOfCells.size());

        return new Maze(mazeField);
    }
}
