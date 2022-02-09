package com.string.service;

import com.string.util.ExcelParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import com.google.common.io.Resources;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.List;


@Service
public class BracketsService {

    private final ExcelParser excelParser;

    public BracketsService(ExcelParser excelParser) {
        this.excelParser = excelParser;
    }

    public void detectBracketsType(String filePath) {
        List<String> bracketsList = null;

        //ornek olsun diye filePath-a bir deger veriyorum
        filePath = "templates/brackets.xlsx";

        try {
            var byteArray = Resources.toByteArray(Resources.getResource(filePath));
            InputStream file = new ByteArrayInputStream(byteArray);
            bracketsList = excelParser.parseExcelToBracketList(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String brackets: bracketsList) {
            if (areBracketsShaped(brackets)) System.out.println("Dogru");
            else System.out.println("Yanlis");
        }
    }

    private boolean areBracketsShaped(String brackets) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                deque.push(bracket);
                continue;
            }

            if (deque.isEmpty()) return false;

            char check;
            switch (bracket) {
                case ')':
                    check = deque.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = deque.pop();
                    if (check == '(' || check == '[') return false;
                    break;
                case ']':
                    check = deque.pop();
                    if (check == '(' || check == '{') return false;
                    break;
            }
        }

        return (deque.isEmpty());
    }
}
