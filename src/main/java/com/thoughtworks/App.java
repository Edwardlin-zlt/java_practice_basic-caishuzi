package com.thoughtworks;

import com.thoughtworks.answergenerator.FileAnswerGenerator;
import com.thoughtworks.answergenerator.RandomAnswerGenerator;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private final static String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六"};

    public static void main(String[] args) {
        String answer = getAnswer();
        GameJudger gameJudger = new GameJudger(answer);
        for (int i = 0; i < 6; i++) {
            String userAnswer = sc.next();
            try {
                if (gameJudger.judgeAnswer(userAnswer)) {
                    // TODO 如何提取这几个sout
                    System.out.println(userAnswer + " // 第" + CHINESE_NUMBER[i] + "次");
                    System.out.println(gameJudger.getGuessHistoryDescribe());
                    System.out.print("You Win!!!!!!!");
                    return;
                } else {
                    System.out.println(userAnswer + " // 第" + CHINESE_NUMBER[i] + "次");
                    System.out.println(gameJudger.getGuessHistoryDescribe());
                }
            } catch (WrongInputException e) {
                i--;
                System.out.println(userAnswer);
                System.out.println(gameJudger.getGuessHistoryDescribe());
            }
        }
        System.out.print("Unfortunately, you have no chance, the answer is " + answer + "");
    }

    public static String getAnswer() {
        String answer;
        final String answerFile = "src/main/resources/answer.txt";
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
