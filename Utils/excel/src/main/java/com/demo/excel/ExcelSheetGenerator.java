package com.demo.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

public class ExcelSheetGenerator {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/home/arunk/Analytics/Apollo/Apollo.xls");
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(2);
			System.out.println(sheet.getSheetName());
			CellStyle cellStyle = wb.createCellStyle();
			CreationHelper createHelper = wb.getCreationHelper();
			cellStyle.setDataFormat(
					createHelper.createDataFormat().getFormat("dd/mm/yy h:mm:ss"));
			int count = 1;
			for (int i=1;i<100;i++) {
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(i);
				cell = row.createCell(1);
				Date date = new Date(new Date().getTime() + (long) (Math.random()*10000000));
				System.out.println((long) (Math.random()*100000));
				cell.setCellValue(date);
				cell.setCellStyle(cellStyle);
				System.out.println(count++);
			}
			
			FileOutputStream fos = new FileOutputStream("/home/arunk/Analytics/Apollo/Apollo1.xls");
			wb.write(fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
