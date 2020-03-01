package com.thoughtworks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private static Random r = new Random();

    public static void main(String[] args) {
        // 1. getAnswer
        List<Integer> answer = getAnswer();
        GameJudger gameJudger = new GameJudger(answer);
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        final String answerFile = "src/main/resources/answer.txt.wrong";
        try (FileInputStream fileInputStream = new FileInputStream(answerFile)) {
            StringBuilder fileContent = new StringBuilder();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, len));
            }
            String answerStr = fileContent.toString().trim();
            char[] chars = answerStr.toCharArray();
            for (Character c: chars) {
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
