package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.WorksheetDocumentImpl;

public class XLutills {

	public static void main(String[] args) throws IOException   {
		FileInputStream fi = new FileInputStream("C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\testxlfile.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		wb.createSheet("ramusheet2");
	    Sheet ws1=	wb.getSheet("Sheet1");
        
        Row row1=	ws1.getRow(1);
        
       Cell cell1=   row1.getCell(1);
       
       Cell cell2=row1.getCell(2);
       
      String str1= cell1.getStringCellValue();
     String   str2=cell2.getStringCellValue();
        
      System.out.println(str1 + "    "+str2);
		
		FileOutputStream fo= new FileOutputStream("C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\result.xlsx");
		wb.write(fo);
	  Sheet demosheet=	wb.createSheet("demosheet2");
	  Row row0= demosheet.createRow(0);
	  ;
	Cell cell0=  row0.createCell(0 );
	  System.out.println(cell0);
	


}
	
}
