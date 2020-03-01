package com.thoughtworks.answergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnswerGenerator implements AnswerGenerator{
    private static Random r = new Random();

    @Override
    public List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 4) {
            answer.add(r.nextInt(10));
        }
        return answer;
    }
}
