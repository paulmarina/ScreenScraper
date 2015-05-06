package org.screenscraper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

		// createNewFile() method creates a new, empty file if and only if a
		// file with this name does not yet exist

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Wlw");

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

			File excelFile = new File("C:\\Screen scraper myData2.xls");
			if (!excelFile.exists()) {
				excelFile.createNewFile();
				Row firstRow = sheet.createRow(0);
				Cell cell0 = firstRow.createCell(0);
				cell0.setCellValue("Company");
				Cell cell1 = firstRow.createCell(1);
				cell1.setCellValue("Website");
				Cell cell2 = firstRow.createCell(2);
				cell2.setCellValue("Areas of Application");
				Cell cell3 = firstRow.createCell(3);
				cell3.setCellValue("Country");
				Cell cell4 = firstRow.createCell(4);
				cell4.setCellValue("City");
				Cell cell5 = firstRow.createCell(5);
				cell5.setCellValue("Year of Establishment");
				Cell cell6 = firstRow.createCell(6);
				cell6.setCellValue("NumberOfEmployees");
				Cell cell7 = firstRow.createCell(7);
				cell7.setCellValue("Name1");
				Cell cell8 = firstRow.createCell(8);
				cell8.setCellValue("JobTitle1");
				Cell cell9 = firstRow.createCell(9);
				cell9.setCellValue("Name2");
				Cell cell10 = firstRow.createCell(10);
				cell10.setCellValue("JobTitle2");
				Cell cell11 = firstRow.createCell(11);
				cell11.setCellValue("Email");
				Cell cell12 = firstRow.createCell(12);
				cell12.setCellValue("Phone");
				Cell cell13 = firstRow.createCell(13);
				cell13.setCellValue("MailingAddress");
				
				

			} 				
				FileOutputStream out = new FileOutputStream(excelFile);				
				workbook.write(out);
				out.close();
				System.out.println("data written successfully on disk.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
