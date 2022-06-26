package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLutills {
    public static	FileInputStream fi;
    public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	private static int rownum;
	public static Cell cell;
	public static CellStyle style;
	
	
	
	public static int getRowCount (String xlfile, String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    int  rowcount=ws.getLastRowNum();
	    wb.close();
	    fi.close();
	    return  rowcount;
	}
      
	public static short getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new HSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
	   row= ws.getRow(rownum);
	   short   columncount= row.getLastCellNum();
	   wb.close();
		fi.close();
		return columncount;
	}
	
	public static String getStringCellData ( String xlfile,String  xlsheet,int rownum,int colnum) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb=new HSSFWorkbook(fi);
	ws= wb.getSheet(xlsheet);
	row= ws.getRow(rownum);
	String data;
			try {
				cell=row.getCell(colnum);
				data=cell.getStringCellValue();
				
			} catch (Exception e) {
				data=" ";
			}
	wb.close();
	fi.close();
	return data;
		
	}
	public static double getNumaricCellData ( String xlfile,String  xlsheet,int rownum,int colnum) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb=new HSSFWorkbook(fi);
	ws= wb.getSheet(xlsheet);
	row= ws.getRow(rownum);
	double data;
			try {
				cell=row.getCell(colnum);
				data=cell.getNumericCellValue();
				
			} catch (Exception e) {
				data=0;
			}
	wb.close();
	fi.close();
	return data;
}
	public static boolean getBooleanCellData ( String xlfile,String  xlsheet,int rownum,int colnum) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb=new HSSFWorkbook(fi);
	ws= wb.getSheet(xlsheet);
	row= ws.getRow(rownum);
	boolean data;
			try {
				cell=row.getCell(colnum);
				data=cell.getBooleanCellValue();
				
			} catch (Exception e) {
				data=false;
			}
	wb.close();
	fi.close();
	return data;
}
	public static void setCellData(String xlfile,String  xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
				
	}
	
	public static void fillGreenColour (String xlfile,String  xlsheet,int rownum,int colnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style= wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
				
	}
	
	public static void fillRedColour (String xlfile,String  xlsheet,int rownum,int colnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style= wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	
}
}