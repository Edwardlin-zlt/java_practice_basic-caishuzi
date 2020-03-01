package com.thoughtworks.answergenerator;

import java.io.IOException;

public interface AnswerGenerator {
    String getAnswer() throws IOException; // TODO randomAnswerGenerator throw?? // try...在File里面处理?
}
