package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapExcelDemo {

	public static LinkedHashMap<String,String> mapExcelDemo(String excelFileName,String sheetName) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\AnilY\\MavenDemo\\src\\main\\java\\resources\\"+excelFileName+".xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		LinkedHashMap<String,String> lhm=new LinkedHashMap<String, String>();
		int rowCount=sheet.getPhysicalNumberOfRows();
		for(int i=1;i<rowCount;i++)
		{
			Row r=sheet.getRow(i);
			String fieldName=r.getCell(0).getStringCellValue();
			String fieldValue=r.getCell(1).getStringCellValue();
			lhm.put(fieldName, fieldValue);
		}
		workbook.close();
		return lhm;
	}
}
