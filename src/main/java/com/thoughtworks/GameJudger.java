package com.thoughtworks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameJudger {
    private List<Integer> answer;
    private List<List<Integer>> guessHistory = new LinkedList<>();
    private String curDescribe = "";
    private String guessHistoryDescribe = "";

    public GameJudger(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean judgeAnswer(List<Integer> userAnswer) throws WrongInputException {
        // 1. 合法输入
        if (userAnswer.size() != 4) {
            throw new WrongInputException("Wrong input");
        }
        // 2. judge A B
        byte aTypeAnswerCounter;
        byte bTypeAnswerCounter;
        for (int i = 0; i < userAnswer.size(); i++) {
            if (answer.)
        }


        // 5. return boolean
        for (Integer integer : userAnswer) {

        }
        // 5. put into guessHistory
        updateHistory(userAnswer);
        return true;
    }

    private void updateHistory(List<Integer> userAnswer, String curDescribe) {
        guessHistory.add(userAnswer);

        // update curDescribe

        // update guessHistoryDescribe
    }
}
