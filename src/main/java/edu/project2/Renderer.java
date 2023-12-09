package edu.project2;

import java.util.List;

public interface Renderer {

    void render(Maze maze);

    void render(Maze maze, List<Coordinate> path);

}
