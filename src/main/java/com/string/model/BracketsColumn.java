package com.string.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Row;

@AllArgsConstructor
@Getter
public enum BracketsColumn {

    BRACKETS(0);

    private int columnNumber;

    public String getValue(Row row) {
        var cell = row.getCell(this.columnNumber);

        return cell != null ? row.getCell(this.columnNumber).toString() : "";
    }
}
