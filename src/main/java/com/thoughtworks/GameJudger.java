package com.thoughtworks;

import java.util.HashSet;
import java.util.Set;

public class GameJudger {
    private String answer;
    private String guessHistoryDescribe = "";

    public GameJudger(String answer) {
        this.answer = answer;
    }

    public String getGuessHistoryDescribe() {
        return guessHistoryDescribe;
    }

    public boolean judgeAnswer(String userAnswer) throws WrongInputException {
        checkInputAnswer(userAnswer);
        byte aTypeAnswerCounter = 0;
        byte bTypeAnswerCounter = 0;
        for (int i = 0; i < userAnswer.length(); i++) {
            char curValue = userAnswer.charAt(i);
            if (answer.charAt(i) == curValue){
                aTypeAnswerCounter++;
            } else if (answer.contains(Character.toString(curValue))){
                bTypeAnswerCounter++;
            }
        }

        String curDescribe = aTypeAnswerCounter+ "A" + bTypeAnswerCounter + "B";
        updateHistory(userAnswer, curDescribe);
        return aTypeAnswerCounter == answer.length();
    }

    private void checkInputAnswer(String userAnswer) throws WrongInputException {
        Set<Character> userAnswerSet = new HashSet<>();
        for (int i=0; i<userAnswer.length(); i++){
            userAnswerSet.add(userAnswer.charAt(i));
        }
        if (userAnswerSet.size() != 4) {
            updateHistory(userAnswer, "Wrong input");
            throw new WrongInputException("Wrong input");
        }
    }

    private void updateHistory(String userAnswer, String curDescribe) {
        guessHistoryDescribe += userAnswer + " " + curDescribe + "\n";
    }
}
