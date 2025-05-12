package com.automation.tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadTest {

    @Test
    public void readExcelFile() {
        String excelPath = "C:\\Users\\GOVINDA COMP YEOLA\\OneDrive\\Desktop\\project\\com.automation\\src\\test\\resources\\manoj.xlsx"; 

        try (FileInputStream file = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheet("Sheet1");
            
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Reading Excel Data:");
            
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                System.out.println("Row " + (i + 1) + ": " + row.getCell(0).toString() + " | " + row.getCell(1).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
