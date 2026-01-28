package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public static Object[][] getDataFromExcel(String path, String sheet) throws IOException
	{
		Object [][] data = null;
		
		try
		{
			FileInputStream f = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(f);
			Sheet s = wb.getSheet(sheet);
			
			int rows = s.getPhysicalNumberOfRows();
			int cells = s.getRow(0).getPhysicalNumberOfCells();
			
			data = new Object[rows-1][cells];
			
			for (int i = 1; i < rows ; i++) 
			{
				for (int j = 0; j < cells ; j++)
				{
					data[i-1][j] = s.getRow(i).getCell(j).toString(); 
				}
			}
			
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return data;
	}
	
	public static String getDataFromExcel(int row,int cell,String path,String sheet)
	{
		String data = "";
		try
		{
			FileInputStream f = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(f);
			Sheet s = wb.getSheet(sheet);
			
			data = s.getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
}
