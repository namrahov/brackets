package com.string.mapper;

import org.apache.poi.ss.usermodel.Row;

import static com.string.model.PalindromeColumn.PALINDROME;

public class PalindromeMapper {

    public static String buildNumberList(Row row) {
        return PALINDROME.getValue(row);
    }
}
