import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.examples.NewWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class creating_new_work_sheet {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fi = new FileInputStream("C:\\Users\\RamaKrishna\\OneDrive\\Documents\\workers status in companey.xlsx");
		
		Workbook wb = new HSSFWorkbook(fi);
		Sheet ws2=wb.createSheet("ramudtasheet");
		Sheet ws1 = wb.getSheet("datasheet1");
		Row row=ws1.getRow(0);
		Cell c=row.getCell(0);
		
		CellStyle passstyle =wb.createCellStyle();
		passstyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
		passstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		CellStyle failstyle=wb.createCellStyle();
		failstyle.setFillForegroundColor(IndexedColors.RED.index);
		failstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		FileOutputStream fo=new FileOutputStream("C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\Ramuxl file.xlsx");
		wb.write(fo);
	   Sheet ws=wb.createSheet("krishnadata");
	   Row r0= ws.createRow(0);
	   Cell c0= r0.createCell(0);
		c0.setCellValue(RichTextString.class.getName());
		
		
	}

}
