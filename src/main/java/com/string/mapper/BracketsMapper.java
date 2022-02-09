package com.string.mapper;

import org.apache.poi.ss.usermodel.Row;

import static com.string.model.BracketsColumn.BRACKETS;

public class BracketsMapper {

    public static String buildBracketsList(Row row) {
        return BRACKETS.getValue(row);
    }
}
