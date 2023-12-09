package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public List<String> clusterize(String brackets) {
        List<String> bracketsList = new ArrayList<>();
        int openedBrackets = 0;
        int closedBrackets = 0;
        String bracketsCluster = "";
        for (Character bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                openedBrackets++;
            } else if (bracket == ')') {
                closedBrackets++;
            }
            if (openedBrackets == closedBrackets) {
                bracketsCluster += bracket;
                bracketsList.add(bracketsCluster);
                bracketsCluster = "";
            } else {
                bracketsCluster += bracket;
            }
        }
        return bracketsList;
    }
}
