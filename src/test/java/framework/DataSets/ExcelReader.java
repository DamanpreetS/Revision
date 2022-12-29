package framework.DataSets;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader {

	
	
	@Test(dataProvider = "data")
	public void readExcel2(String str1, String str2, String str3) throws IOException
	{
	System.out.println(str1 +str2+str3);
	}
	@DataProvider(name="data")
	public Object[][] data() throws IOException
	{
		DataFormatter formatter=new DataFormatter();
		FileInputStream fis=new FileInputStream("D:\\workspace\\Test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		XSSFRow row=sheet.getRow(0);
		
		int cellCount=row.getLastCellNum();
		
		Object data[][]=new Object[rowCount-1][cellCount];
		
		for(int i=1;i<rowCount;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<cellCount;j++)
			{
				Cell c=row.getCell(j);
				data[i-1][j]=formatter.formatCellValue(c);
			}
			
		}
		return data;
		
		
	}
}
