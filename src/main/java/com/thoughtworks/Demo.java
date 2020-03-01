package com.thoughtworks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/answer.txt");
        StringBuilder fileContent = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buffer)) != -1) {
            fileContent.append(new String(buffer, 0, len));
        }
        fileInputStream.close();
        System.out.println(Arrays.toString(fileContent.toString().split("\n")));
    }
}
