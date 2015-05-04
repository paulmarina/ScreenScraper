package org.screenscraper.main;

import org.screenscraper.excel.ReadWriteExcelFile;

public class Program {

	public static void main(String args[]) {

		 

		//System.out.println("cevaaaaaaaa");
		/*try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ReadWriteExcelFile rw = new ReadWriteExcelFile();
		rw.readXLSFile();
		//rw.writeXLSFile();
	}
}
