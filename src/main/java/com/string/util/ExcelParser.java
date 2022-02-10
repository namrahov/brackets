package com.string.util;

import com.string.mapper.PalindromeMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelParser {

    public List<String> parseExcelToNumberList(InputStream file) {
        List<String> numberList = new ArrayList<>();

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (isRowEmpty(row)) break;
            if (row.getRowNum() == 0) continue;

            String brackets = PalindromeMapper.buildBracketsList(row);

            numberList.add(brackets);
        }

        return numberList;
    }

    private boolean isRowEmpty(Row row) {
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) return false;
        }
        return true;
    }
}
