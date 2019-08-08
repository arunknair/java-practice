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

public class InsertScriptGenerator {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/home/arunk/Analytics/Apollo/inserts/Sample.xls");
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(2);
			System.out.println(sheet.getSheetName());
			String tableName = sheet.getSheetName();
			System.out.println("Last row : " + sheet.getLastRowNum());
			StringBuilder query = new StringBuilder();
			for(int j=0;j<sheet.getLastRowNum();j++) {
				Row headerRow = sheet.getRow(0);
				query.append(" INSERT INTO " + tableName + " (");
				for (int i=0; i<headerRow.getLastCellNum();i++) {
					query.append(headerRow.getCell(i) + ",");
				}
				query.deleteCharAt(query.length() - 1);
				query.append(") VALUES ( ");
				Row insertRow = sheet.getRow(1);
				for (int i=0; i<headerRow.getLastCellNum();i++) {
					if (insertRow.getCell(i).getCellType() == Cell.CELL_TYPE_NUMERIC
							|| insertRow.getCell(i).getCellType() == Cell.CELL_TYPE_FORMULA)
						query.append((int)insertRow.getCell(i).getNumericCellValue() + ",");
					else 
						query.append(insertRow.getCell(i)+ ",");
				}
				query.deleteCharAt(query.length() - 1);
				query.append("); \n");
			}
			System.out.println("Query : \n" + query.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
