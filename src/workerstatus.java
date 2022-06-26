import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.devtools.v100.dom.model.ShadowRootType;

public class workerstatus {

	public static void main(String[] args) throws IOException
   {
	FileInputStream fi = new FileInputStream("C:\\Users\\RamaKrishna\\OneDrive\\Documents\\workers status in companey.xlsx");
	//FileInputStream fi2 = new FileInputStream("C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\testxlfile.xlsx");
	
	Workbook wb= new XSSFWorkbook(fi);
	Sheet ws1= wb.getSheet("datasheet1");
	
    int rowcount=ws1.getLastRowNum();
    for (int i =1 ; i <=rowcount; i++) {
    	Row row0= ws1.getRow(i);
    	Cell  c0 = row0.getCell(0);
    	Cell  c1 = row0.getCell(1);
    	Cell  c2 = row0.getCell(2);
    	Cell  c3 = row0.getCell(3);
    	Cell  c4= row0.getCell(4);
      
    	int empno =(int) c0.getNumericCellValue();
    	String name =c1.getStringCellValue();
    	int  salary =(int) c2.getNumericCellValue();
    	String status =c3.getStringCellValue();
    	//String str4=c4.getStringCellValue();
    String data;

    	System.out.println(empno+"   "+name+"   "+salary+"    "+status);	
   
	

	}
    CellStyle passstyle = wb.createCellStyle();
	passstyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
	passstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	Row r1=ws1.getRow(1);
      Cell c3=r1.getCell(3);
	c3.setCellStyle(passstyle);
	
	CellStyle failstyle = wb.createCellStyle();
	failstyle.setFillForegroundColor(IndexedColors.RED.index);
	failstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	Row r2=ws1.getRow(2);
    Cell rc3=r2.getCell(3);
	rc3.setCellStyle(failstyle);
	
	Cell c4= r1.createCell(4);
	c4.setCellValue(true);
	c4.setCellStyle(passstyle);
	
	Cell r2c4= r2.createCell(4);
	r2c4.setCellValue(false);
	r2c4.setCellStyle(failstyle);

	
	FileOutputStream fo = new FileOutputStream("C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\dataresult.xlsx");
	wb.write(fo);
	fi.close();
	fo.close();
	

}
}
