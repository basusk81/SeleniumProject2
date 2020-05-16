package ExcelHandling;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.blip.PNG;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataPull {
	
	@Test
	public void DataPull() throws IOException
	{
		 //Input Stream
		FileInputStream fis1 = new FileInputStream("C:\\Selenium\\TestData3.xlsx");
		XSSFWorkbook workbook3 = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook3.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(1);
		
		int r=1;
		
		String src1 = sheet.getRow(r).getCell(1).getStringCellValue();
		System.out.println("Value of Src1" +src1);
		
		String src2 = sheet.getRow(r).getCell(2).getStringCellValue();
		System.out.println("Value of Src2" +src2);
		
		//return src1;
		//return src2;
		
	}

}
