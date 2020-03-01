package com.thoughtworks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    private static Random r = new Random();
    private static Scanner sc = new Scanner(System.in);
    private final static String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六"};

    public static void main(String[] args) {
        // 1. getAnswer
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
        System.out.print("Unfortunately, you have no chance, the answer is " + answer + "");
    }


    private static List<Integer> parseAnswerInput(String answerStr) {
        List<Integer> answer = new ArrayList<>();
        for (char c : answerStr.toCharArray()) {
            answer.add(Character.getNumericValue(c));
        }
        return answer;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        final String answerFile = "src/main/resources/answer.txt";
        try (FileInputStream fileInputStream = new FileInputStream(answerFile)) {
            StringBuilder fileContent = new StringBuilder();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, len));
            }
            String answerStr = fileContent.toString().trim();
            char[] chars = answerStr.toCharArray();
            for (Character c : chars) {
                answer.add(Character.getNumericValue(c));
            }
        } catch (IOException e) {
            // 写入日志
//            e.printStackTrace();
            answer = generateAnswer();
        }
        return answer;
    }

    private static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 4) {
            answer.add(r.nextInt(10));
        }
        return answer;
    }
}
