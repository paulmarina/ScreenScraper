package org.screenscraper.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.screenscraper.parsers.*;
import org.screenscraper.objects.*;
import org.screenscraper.excel.ReadWriteExcelFile;


public class Program {

	public static void main(String args[]) {

		System.out.println("cevaaaaaaaa");
		
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:/Users/ALINAM/Desktop/sss.html"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
		
		MainPageHtmlParser mphp = new MainPageHtmlParser();
		List<CompanyUrl> companyUrls = mphp.parse(content);
		
		for (CompanyUrl companyUrl : companyUrls) {
			System.out.println(companyUrl.getUrl());
		}
		 

		//System.out.println("cevaaaaaaaa");
		/*try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ReadWriteExcelFile rw = new ReadWriteExcelFile();
		ArrayList<Company> listCompany = new ArrayList<Company>();
		listCompany = rw.readXLSFile();
		for (Company company : listCompany) {
			
			System.out.println(company.getCompany());
			
		}
		//rw.writeXLSFile();
	}
}
