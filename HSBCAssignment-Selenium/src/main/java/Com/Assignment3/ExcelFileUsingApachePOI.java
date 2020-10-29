package Com.Assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExcelFileUsingApachePOI {
	public static WebDriver driver;

	@Test
	public void readExcelFile() throws IOException {

		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Swapnali\\Eclips_Program_RestAPI\\HSBCAssignment-Selenium\\src\\main\\resources\\Apache.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheet("Sheet2");
			int rows = sheet.getLastRowNum();
			Row row;
			for (int i = 0; i <= rows; i++) {
				row = sheet.getRow(i);
				int cells = row.getLastCellNum();
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						System.out.print(" " + cell.getCellType());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(" " + cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(" " + cell.getBooleanCellValue());
						break;
						
					case Cell.CELL_TYPE_ERROR:
						System.out.print(" " + cell.getErrorCellValue());
						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(" " + cell.getNumericCellValue());
						break;
						
					default:
						System.out.println("error");
						break;
					}
					
						}
				System.out.println();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	

	}

}
