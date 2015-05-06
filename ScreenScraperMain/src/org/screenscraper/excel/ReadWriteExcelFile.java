package org.screenscraper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

	public ArrayList<Company> readXLSFile() {

		ArrayList<Company> companyList = new ArrayList<Company>();

		try {
			FileInputStream file = new FileInputStream(new File(
					"C:\\Screen scraper data.xlsx"));

			// Create Workbook instance holding reference to excel file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					continue;
				}

				Company company = new Company();
				company.setCompany(row.getCell(0).getStringCellValue());
				company.setWebsite(row.getCell(1).getStringCellValue());
				company.setAreasOfApplication(row.getCell(2)
						.getStringCellValue());
				company.setCountry(row.getCell(3).getStringCellValue());
				company.setCity(row.getCell(4).getStringCellValue());
				company.setYearOfEstablishment((int) row.getCell(5)
						.getNumericCellValue());
				company.setNumberOfEmployees((int) row.getCell(6)
						.getNumericCellValue());
				company.setName1(row.getCell(7).getStringCellValue());
				company.setJobTitle1(row.getCell(8).getStringCellValue());
				company.setName2(row.getCell(9).getStringCellValue());
				company.setJobTitle2(row.getCell(10).getStringCellValue());
				company.setEmail(row.getCell(11).getStringCellValue());
				company.setPhone(String.valueOf(row.getCell(12)
						.getNumericCellValue()));
				company.setMailingAddress(row.getCell(13).getStringCellValue());

				companyList.add(company);

			}
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return companyList;

	}

	public void writeXLSFile(ArrayList<Company> companyList) {

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Wlw");

		// This data needs to be written (Object[])
		/*Map<String, Object[]> data = new TreeMap<String, Object[]>();
		//data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Amit", "Shukla" });
		data.put("3", new Object[] { 2, "Lokesh", "Gupta" });
		data.put("4", new Object[] { 3, "John", "Adwards" });
		data.put("5", new Object[] { 4, "Brian", "Schultz" });*/

		// Iterate over data and write to sheet
		/*Set<String> keyset = data.keySet();
		int rownum = 1;
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
		}*/
		
		int rownum = 1;
		for (Company company : companyList) {
			Row row = sheet.createRow(rownum++);
			 Cell cell0 = row.createCell(0);
			 cell0.setCellValue(company.getCompany());
			 Cell cell1 = row.createCell(1);
			 cell1.setCellValue(company.getWebsite());
			 Cell cell2 = row.createCell(2);
			 cell2.setCellValue(company.getAreasOfApplication());
			 Cell cell3 = row.createCell(3);
			 cell3.setCellValue(company.getCountry());
			 Cell cell4 = row.createCell(4);
			 cell4.setCellValue(company.getCity());
			 Cell cell5 = row.createCell(5);
			 cell5.setCellValue(company.getYearOfEstablishment());
			 Cell cell6 = row.createCell(6);
			 cell6.setCellValue(company.getNumberOfEmployees());
			 Cell cell7 = row.createCell(7);
			 cell7.setCellValue(company.getName1());
			 Cell cell8 = row.createCell(8);
			 cell8.setCellValue(company.getJobTitle1());
			 Cell cell9 = row.createCell(9);
			 cell9.setCellValue(company.getName2());
			 Cell cell10 = row.createCell(10);
			 cell10.setCellValue(company.getJobTitle2());
			 Cell cell11 = row.createCell(11);
			 cell11.setCellValue(company.getEmail());
			 Cell cell12 = row.createCell(12);
			 cell12.setCellValue(company.getPhone());
			 Cell cell13 = row.createCell(13);
			 cell13.setCellValue(company.getMailingAddress());
		
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File(
					"C:\\testWrite.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("data written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
