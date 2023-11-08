package edu.hw1;

public class Task8 {

    public boolean knightBoardCapture(int[][] field) {
        boolean flag = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1 && !check(i,j,field)) {
                    flag = false;
                }
            }
        }
        return flag;
    }


    boolean check(int i, int j, int[][] field) {
        boolean flag = true;
        if (i - 1 >= 0 && j - 2 >= 0) {
            if (field[i - 1][j - 2] == 1) {
                flag = false;
            }
        }
        if (i - 2 >= 0 && j - 1 >= 0) {
            if (field[i - 2][j - 1] == 1) {
                flag = false;
            }
        }
        if (i - 1 >= 0 && j + 2 < field[i].length) {
            if (field[i - 1][j + 2] == 1) {
                flag = false;
            }
        }
        if (i - 2 >= 0 && j + 1 < field[i].length) {
            if (field[i - 2][j + 1] == 1) {
                flag = false;
            }
        }
        if (i + 1 < field.length && j - 2 >= 0) {
            if (field[i + 1][j - 2] == 1) {
                flag = false;
            }
        }
        if (i + 1 < field.length && j + 2 < field[i].length) {
            if (field[i + 1][j + 2] == 1) {
                flag = false;
            }
        }
        if (i + 2 < field.length && j + 1 < field[i].length) {
            if (field[i + 2][j + 1] == 1) {
                flag = false;
            }
        }
        if (i + 2 < field.length && j - 1 >= 0) {
            if (field[i + 2][j - 1] == 1) {
                flag = false;
            }
        }
        return flag;
    }
}
