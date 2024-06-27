package com.joeyroomhost.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PropertyReader
{
	// in sheet 1 row and colum details
	public static double getdata(String filename,int row,int colu) throws Exception
	{
		String filepath=".//TestData//"+filename+".xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(instream) ;
		XSSFSheet sheet=workbook.getSheet("sheet1");
		return sheet.getRow(row).getCell(colu).getNumericCellValue();
	}
	// particual row
	public static List<String> getdata(String filename,int row) throws Exception
	{
		String filepath=".//TestData//"+filename+".xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(instream);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int cellscount=sheet.getRow(row).getLastCellNum();
		List<String>rowdata=new ArrayList<String>();
		for(int i=0;i<cellscount;i++)
		{
			String data=sheet.getRow(row).getCell(i).getStringCellValue();
			rowdata.add(data);
//			DataFormatter format=new DataFormatter();
//			String data = format.formatCellValue(null);
		}
		return rowdata;
	}
	//sheet all data
	public static String[][] getdata(String filename) throws Exception
	{
		String filepath=".//TestData//"+filename+".xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(instream);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rows= sheet.getLastRowNum();
		System.out.println("rows="+rows);
		int cellscount=sheet.getRow(rows).getLastCellNum();
		System.out.println("cellscount="+cellscount);
		String info[][]=new String[rows][cellscount];
		int k=0,l=0;
		for(int i=1;i<=rows;i++)	
		{
			l=0;
			for(int j=0;j<cellscount;j++)
			{
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				info[k][l]=data;
				l++;
			}
			k++;
		}
		return info;
	}
	public static String getLocater(String filename,String key) throws Exception
	{
		String filepath=".//Locators//"+filename+".properties";
		FileInputStream instream=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(instream);
		return pro.getProperty(key);
	}
	
}
