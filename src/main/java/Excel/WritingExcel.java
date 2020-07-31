package Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {
	
	public void WriteData(String Price,int i) throws IOException
	{

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh= wb.createSheet("Output_Data");
		Row row1 = sh.createRow(0);
		
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("tv price");
		Cell cell2=row1.createCell(1);
		cell2.setCellValue("total amount");
		
		Row row2 = sh.createRow(1);
		Cell cell3=row2.createCell(i);
		cell3.setCellValue(Price);
		
		//String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File file = new File("C:\\Users\\SUKANNYA\\eclipse-workspace\\Flipkart.com\\ExcelSheets\\output"+".xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		
		wb.close();
	}

}
