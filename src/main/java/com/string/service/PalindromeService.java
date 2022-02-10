package com.string.service;

import com.google.common.io.Resources;
import com.string.util.ExcelParser;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PalindromeService {

    private final ExcelParser excelParser;

    public PalindromeService(ExcelParser excelParser) {
        this.excelParser = excelParser;
    }

    public void detectPalindromeOfNumber(String filePath) {

        List<String> numberList = null;

        //ornek olsun diye filePath-a bir deger veriyorum
        filePath = "templates/palindrome.xlsx";

        try {
            var byteArray = Resources.toByteArray(Resources.getResource(filePath));
            InputStream file = new ByteArrayInputStream(byteArray);
            numberList = excelParser.parseExcelToNumberList(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String number : numberList) {
            findPalindrome(Long.parseLong(number.split("\\.")[0]));
        }
    }

    private void findPalindrome(long number) {
        int count = 0;
        while (!isPalindrome(number)) {
            number += reverseNumber(number);
            count++;
        }

        System.out.println(number + " " + count);
    }

    private long reverseNumber(long number) {
        long reverse = 0;
        long temp;

        while (number != 0) {
            temp = number % 10;

            reverse = (reverse * 10) + temp;

            number = number / 10;
        }

        return reverse;
    }

    private boolean isPalindrome(long number) {
        return reverseNumber(number) == number;
    }
}
