package com.thoughtworks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameJudger {
    private List<Integer> answer;
    private String guessHistoryDescribe = "";

    public GameJudger(List<Integer> answer) {
        this.answer = answer;
    }

    public String getGuessHistoryDescribe() {
        return guessHistoryDescribe;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public boolean judgeAnswer(List<Integer> userAnswer) throws WrongInputException {
        checkInputAnswer(userAnswer);
        byte aTypeAnswerCounter = 0;
        byte bTypeAnswerCounter = 0;
        for (int i = 0; i < userAnswer.size(); i++) {
            int curValue = userAnswer.get(i);
            if (answer.get(i).equals(curValue)){
                aTypeAnswerCounter++;
            } else if (answer.contains(curValue)){
                bTypeAnswerCounter++;
            }
        }

        String curDescribe = aTypeAnswerCounter+ "A" + bTypeAnswerCounter + "B";
        updateHistory(userAnswer, curDescribe);
        return aTypeAnswerCounter == 4;
    }

    private void checkInputAnswer(List<Integer> userAnswer) throws WrongInputException {
        Set<Integer> userAnswerSet = new HashSet<>(userAnswer);
        if (userAnswerSet.size() != 4) {
            updateHistory(userAnswer, "Wrong input");
            throw new WrongInputException("Wrong input");
        }
    }

    private void updateHistory(List<Integer> userAnswer, String curDescribe) {
        StringBuilder userAnswerStr = new StringBuilder();
        for (Integer integer : userAnswer) {
            userAnswerStr.append(integer);
        }
        guessHistoryDescribe += userAnswerStr.append(" ").append(curDescribe).append("\n");
    }
}
