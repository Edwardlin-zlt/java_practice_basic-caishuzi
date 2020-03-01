package com.thoughtworks;

import com.thoughtworks.answergenerator.FileAnswerGenerator;
import com.thoughtworks.answergenerator.RandomAnswerGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private final static String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六"};

    public static void main(String[] args) {
        List<Integer> answer = getAnswer();
        GameJudger gameJudger = new GameJudger(answer);
        for (int i = 0; i < 6; i++) {
            String userAnswerStr = sc.next();
            List<Integer> userAnswer = parseAnswerInput(userAnswerStr);
            try {
                if (gameJudger.judgeAnswer(userAnswer)) {
                    System.out.println(userAnswerStr + " // 第" + CHINESE_NUMBER[i] + "次");
                    System.out.println(gameJudger.getGuessHistoryDescribe());
                    System.out.print("You Win!!!!!!!");
                    return;
                } else {
                    System.out.println(userAnswerStr + " // 第" + CHINESE_NUMBER[i] + "次");
                    System.out.println(gameJudger.getGuessHistoryDescribe());
                }
            } catch (WrongInputException e) {
                i--;
                System.out.println(userAnswerStr);
                System.out.println(gameJudger.getGuessHistoryDescribe());
            }
        }
        StringBuilder answerStr = new StringBuilder();
        for (Integer integer : answer) {
            answerStr.append(integer);
        }
        System.out.print("Unfortunately, you have no chance, the answer is " + answerStr + "");
    }


    private static List<Integer> parseAnswerInput(String answerStr) {
        List<Integer> answer = new ArrayList<>();
        for (char c : answerStr.toCharArray()) {
            answer.add(Character.getNumericValue(c));
        }
        return answer;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer;
        final String answerFile = "src/main/resources/answer.txt.wrong";
        FileAnswerGenerator fileAnswerGenerator = new FileAnswerGenerator(answerFile);
        try {
            answer = fileAnswerGenerator.getAnswer();
        } catch (IOException e) {
            RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
            answer = randomAnswerGenerator.getAnswer();
        }
        return answer;
    }
}
