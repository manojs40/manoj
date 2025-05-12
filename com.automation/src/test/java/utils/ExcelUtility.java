package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

	private static final String FILE_PATH = "./reports/TestResults.xlsx";

	public static void writeTestResult(String testCase, String status, String message) {
		File file = new File(FILE_PATH);
		Workbook workbook;
		Sheet sheet;

		try {
			if (file.exists()) {
				workbook = WorkbookFactory.create(file);
				sheet = workbook.getSheetAt(0);
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet("Test Results");

				// Create Header Row
				Row header = sheet.createRow(0);
				header.createCell(0).setCellValue("Test Case");
				header.createCell(1).setCellValue("Status");
				header.createCell(2).setCellValue("Message");
			}

			int rowNum = sheet.getLastRowNum() + 1;
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(testCase);
			row.createCell(1).setCellValue(status);
			row.createCell(2).setCellValue(message);

			FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
