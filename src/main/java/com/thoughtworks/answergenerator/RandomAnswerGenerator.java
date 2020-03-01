package com.thoughtworks.answergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnswerGenerator implements AnswerGenerator {
    private static Random r = new Random();

    @Override
    public String getAnswer() {
        List<String> answer = new ArrayList<>();
        while (answer.size() < 4) {
            String value = String.valueOf(r.nextInt(10));
            if (answer.contains(value)) {
                continue;
            }
            answer.add(value);
        }
        return String.join("", answer);
//        return (Character[]) answer.toArray(); // 使用Character[]和List<Character>的优劣
    }
}
