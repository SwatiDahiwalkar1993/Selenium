package CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcel(String SheetNmae, int Rownum, int Cellnum) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\OrgData.xlsx");
		
		Workbook wbf = WorkbookFactory.create(fis);
		   
	    Sheet sh = wbf.getSheet("Orgnization");
		   
		Row rw = sh.getRow(Rownum);
		   
		Cell cl = rw.getCell(Cellnum);
		   
		String value = cl.getStringCellValue();

		return value;

	}

}
