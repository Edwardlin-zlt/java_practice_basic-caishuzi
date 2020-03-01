package com.thoughtworks.answergenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAnswerGenerator implements AnswerGenerator {
    private String filePath;

    public FileAnswerGenerator(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Integer> getAnswer() throws IOException {
        List<Integer> answer = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
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
        return answer;
    }
}
