package com.thoughtworks.answergenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AnswerGenerator {
    List<Integer> getAnswer() throws IOException;
}
