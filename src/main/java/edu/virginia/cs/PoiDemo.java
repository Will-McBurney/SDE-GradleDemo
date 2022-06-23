package edu.virginia.cs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiDemo {
	public static void main(String[] args) {
		if (args.length != 1 || !args[0].endsWith(".xlsx")) {
			System.err.println("ERROR: Incorrect argument - you must have one argument which is an xlsx file");
			System.exit(0);
		}
		
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream(new File(args[0]));
			workbook = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: File name entered not found - " + args[0]);
			System.exit(0);
		} catch (IOException e) {
			System.err.println("Error: IO Error when using the input excel file. Ensure the file is closed.");
			System.exit(0);
		}
		
		XSSFSheet mysheet = workbook.getSheetAt(0);
		
		System.out.println("first row: " + mysheet.getFirstRowNum() + " - last row: " + mysheet.getLastRowNum());
		
		//Get the Cell Style of very cell:
		System.out.println("contents: " + mysheet.getRow(0).getCell(0).getStringCellValue() + "\tType" + mysheet.getRow(0).getCell(0).getCellType());
		System.out.println("contents: " + mysheet.getRow(0).getCell(1).getStringCellValue() + "\tType: " + mysheet.getRow(0).getCell(1).getCellType());
		System.out.println("contents: " + mysheet.getRow(1).getCell(0).getNumericCellValue() + "\tType: " + mysheet.getRow(1).getCell(0).getCellType());
		System.out.println("contents: " + mysheet.getRow(1).getCell(1).getCellFormula() + "\tType: " + mysheet.getRow(1).getCell(1).getCellType());
		
		//Print every cell in every row, with line breaks between rows - note that this works for any number of rows or columns in a spreadsheet
		Iterator<Row> rowIter = mysheet.rowIterator();
		while (rowIter.hasNext()) {
			Row r = rowIter.next();
			System.out.println("Row " + r.getRowNum() + ":");
			Iterator<Cell> cellIter = r.cellIterator();
			while (cellIter.hasNext()) {
				Cell c = cellIter.next();
				System.out.println("\tCol " + c.getColumnIndex() + " - Type: " + c.getCellType() + " - Contents: " + c);
			}
		}
	}

}
