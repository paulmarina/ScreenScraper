package org.screenscraper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.screenscraper.objects.Company;

public class ReadWriteExcelFile {

	public void readXLSFile() {

		try {
			FileInputStream file = new FileInputStream(new File(
					"C:\\test1.xlsx"));

			// Create Workbook instance holding reference to excel file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				/*
				 * Iterator<Cell> cellIterator = row.cellIterator(); while
				 * (cellIterator.hasNext()) {
				 * 
				 * Cell cell = cellIterator.next();
				 * 
				 * switch (cell.getCellType()) {
				 * 
				 * 
				 * case Cell.CELL_TYPE_NUMERIC: System.out.print((int)
				 * (cell.getNumericCellValue()) + "\t\t"); break; case
				 * Cell.CELL_TYPE_STRING:
				 * System.out.print(cell.getStringCellValue() + "\t\t"); break;
				 * }
				 * 
				 * 
				 * 
				 * }
				 */

				for (int i = 0; i < 14; i++) {
					
					Cell cell = row.getCell(i);
					

				}

				System.out.println("");
			}
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeXLSFile() {

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");

		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Amit", "Shukla" });
		data.put("3", new Object[] { 2, "Lokesh", "Gupta" });
		data.put("4", new Object[] { 3, "John", "Adwards" });
		data.put("5", new Object[] { 4, "Brian", "Schultz" });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(
					"C:\\testWrite.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("testWrite.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
