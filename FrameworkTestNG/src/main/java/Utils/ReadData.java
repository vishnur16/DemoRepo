package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	FileInputStream fi;
	FileOutputStream fo;
	Workbook wb;
	Sheet ws;
	Row r;
	
	
	public ReadData(String inputpath)
	{
		try {
		fi=new FileInputStream(inputpath);
		wb=WorkbookFactory.create(fi);
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
	public int rowCountNum(String sheet)
	{
		int rowcount;
		ws=wb.getSheet(sheet);
		rowcount=ws.getLastRowNum();
		
		return rowcount;
	}
	public int cellCount(String sheet)
	{
		int cellcount;
		ws=wb.getSheet(sheet);
		r=ws.getRow(0);
		cellcount=r.getLastCellNum();
		
		return cellcount;
	}
	public String getCellData(String sheet,int row,int cell)
	{
		String data="";
		if(wb.getSheet(sheet).getRow(row).getCell(cell).getCellType()==CellType.NUMERIC)
		{
			int celldat=(int) wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(celldat);
		}
		else
		{
			data=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}		
		return data;
	}
	public void setCellData(String sheet,int row,int cell,String Status,String output)
	{
		try {
		ws=wb.getSheet(sheet);
		ws.getRow(row).createCell(cell).setCellValue(Status);
		fo=new FileOutputStream(new File(output));
		wb.write(fo);
		}catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
}
