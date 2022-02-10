package com.string.mapper;

import org.apache.poi.ss.usermodel.Row;

import static com.string.model.PalindromeColumn.BRACKETS;

public class PalindromeMapper {

    public static String buildBracketsList(Row row) {
        return BRACKETS.getValue(row);
    }
}
