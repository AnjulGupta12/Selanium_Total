// READ AND WRITE TABLE
/*
WORKING WITH WEBTABLE IN SELANIUM 
		What it is 
		How to work with it 
		Static way
		Dynamic way
		
<table>		<tr> set row		<td> set data cell		<th> header cell element(bold and center)

<table>
	<tbody>
		<tr>
			<th>Automation Tool</th>
			<th>Licensing</th>
		</tr>
		<tr>
			<td>Selanium</td>
			<td>Free</td>
		</tr>
		<tr>
			<td>UFT</td>
			<td>Paid</td>
		</tr>
	</tbody>
</table>
		
		
		STATIC WAY
			Data is static i.e. Number of rows and columns are fixed.
				//div[@id='main']/table[1]/tbody/tr[1]/th[1]		: tr1 first row & th1 first column
				
				for(int numberOfRows=1; numberOfRows<=3; numberOfRows++){
				for(int numberOfCol=1; numberOfCol<=2; numberOfCol++){
				System.out.println(driver.findElement(By.xpath("//div[@id='main']/table[1]/tbody/tr["+numberOfRows+"]/th["+numberOfCol+"]")));
				}}
				
		DYNAMIC WAY
			Data is dynamic i.e. Number of rows and columns are NOT fixed.
			
				WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/table"));
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				for (WebElement row : rows) {
					List<WebElement> cols = row.findElements(By.tagName("td"));
					for (WebElement col : cols) {
						System.out.print("Column value: " + col.getText());}}}
*/

package Automate_simple_interactions;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableCreation {

	@Test
	public void test() {
		
		FileInputStream fis = null;			//file stream is for table 			
		XSSFWorkbook workbook = null;		//XSSFWorkbook is for that current worksheet 

		String file = ".\\TableData\\TableLearning.xlsx";		//file mai save kiya excel file 

		try {fis = new FileInputStream(file);}catch (FileNotFoundException e1) {e1.printStackTrace();}
																//phir fis mai save kiya table
		
		try {workbook = new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();}
																//XSSFWorkbook mai add kiya current workbook
		
		XSSFSheet sheet = workbook.getSheetAt(0); // workBook.getSheet("Sheet1")

		int rowCount = sheet.getLastRowNum();					// last row number
		int cellCount = sheet.getRow(0).getLastCellNum();		//last column number
		
		System.out.println("Row Count: " + rowCount);
		System.out.println("Column Count: " + cellCount);

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			cellCount = sheet.getRow(rowNo).getLastCellNum(); // 3
			

			for (int cellNo = 0; cellNo < cellCount; cellNo++) {
				Cell cell = sheet.getRow(rowNo).getCell(cellNo);

				if (cell.getCellType() == CellType.STRING)
					System.out.print(sheet.getRow(rowNo).getCell(cellNo).getStringCellValue() + "\t"); // 1,0

				else if (cell.getCellType() == CellType.NUMERIC) {
					if (cellNo == 0)
						System.out.print((int) sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue() + "\t");
					else
						System.out.print(sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue() + "\t");
				}

			}
			System.out.println();
		}

	}

}

//WHY IT IS NOT PRINTING 6TH COLUMN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!