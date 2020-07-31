package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingExcel 
{
	
	 
	public String readData(int i,int j) throws IOException
	{
		File filepath = new File("D:\\COGNIZANT\\Selenium excel\\flipkart.xlsx");
		FileInputStream input = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sh = wb.getSheetAt(0);
		String value = sh.getRow(i).getCell(j).getStringCellValue();
		
		wb.close();
		return value;
		
		
    }

	

}
