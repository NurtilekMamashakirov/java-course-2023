package edu.hw1;

public class Task8 {

    public boolean knightBoardCapture(int[][] field) {
        boolean flag = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    if (!(checkLeft1Up2(i, j, field) && checkLeft2Up1(i, j, field)
                        && checkLeft1Down2(i, j, field) && checkLeft2Down1(i, j, field) && checkRight1Up2(i, j, field)
                        && checkRight1Down2(i, j, field) && checkRight2Down1(i, j, field) &&
                        checkRight2Up1(i, j, field))) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    boolean checkLeft1Up2(int i, int j, int[][] field) {
        if (i - 1 >= 0 && j - 2 >= 0) {
            return field[i - 1][j - 2] != 1;
        }
        return true;
    }

    boolean checkLeft2Up1(int i, int j, int[][] field) {
        if (i - 2 >= 0 && j - 1 >= 0) {
            return field[i - 2][j - 1] != 1;
        }
        return true;
    }

    boolean checkLeft1Down2(int i, int j, int[][] field) {
        if (i - 1 >= 0 && j + 2 < field[i].length) {
            return field[i - 1][j + 2] != 1;
        }
        return true;
    }

    boolean checkLeft2Down1(int i, int j, int[][] field) {
        if (i - 2 >= 0 && j + 1 < field[i].length) {
            return field[i - 2][j + 1] != 1;
        }
        return true;
    }

    boolean checkRight1Up2(int i, int j, int[][] field) {
        if (i + 1 < field.length && j - 2 >= 0) {
            return field[i + 1][j - 2] != 1;
        }
        return true;
    }

    boolean checkRight1Down2(int i, int j, int[][] field) {
        if (i + 1 < field.length && j + 2 < field[i].length) {
            return field[i + 1][j + 2] != 1;
        }
        return true;
    }

    boolean checkRight2Down1(int i, int j, int[][] field) {
        if (i + 2 < field.length && j + 1 < field[i].length) {
            return field[i + 2][j + 1] != 1;
        }
        return true;
    }

    boolean checkRight2Up1(int i, int j, int[][] field) {
        if (i + 2 < field.length && j - 1 >= 0) {
            return field[i + 2][j - 1] != 1;
        }
        return true;
    }

}
