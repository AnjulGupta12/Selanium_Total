/*
ENHANCE AUTOMATION SCRIPTS
 	1. Parameterize your scripts using excel sheets
 	2. 	Capture screenshots in your scripts.
 	3. Handle unexpected exceptions from AUT.
 

 
 */
package EnhanceAutomationScripts;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

class Parameterize_ScreenShot_ExceptionHandling {
	public static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	
	@Test
	void test() {
		//getScreenshotAs method will take arguement for the output type of the file
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Using the FileUtils class copy the generated screenshot file to any location
try {
	FileUtils.copyFile(scrFile, new File("C:\\Users\\some_user\\Desktop\\Image.png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
/*
  APACHE POI: Supports both .xlsx and .xls handling. Interface carries Workbook, sheet, row, cell 
  	With parametrization you can achieve the DATA DRIVEN TESTING
 -------------------------------READ AND WRITE EXCEL FILE 
  ..xlsx Classes ------>	Interface <----------.xls Classes
  XSSFWorkBook ------> WorkBook <------------HSSFWorkBook
 XSSFSheet----------> Sheet <---------------HSSFSheet
  XSSFRow------------> Row   <---------------HSSFRow
  XSSFCell ----------> Cell  <--------------HSSFCell 
 	
 READ
 	//Path from where the excel file has to be read
String filePath = System.getProperty("user.dir") + "\\Cred.xlsx";
	//File input stream which needs the input as the file location
FileInputStream fileStream = new FileInputStream(filePath);
	//Workbook reference of the excel file
XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
	//Sheet which needs to be accessed from within the workbook
XSSFSheet sheet = workbook.getSheet("Sheet1");
	//Count the number of rows
int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	//Iterate the Username/Password/
for (int i = 1; i <= rowCount; i++) {
	//Pass the row number and the cell number from where the value has to be fetched	
driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[4]/a")).click();					
driver.findElement(By.id("usernameLogin")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
driver.findElement(By.id("passwordLogin")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());					
driver.findElement(By.id("login")).click();
String message = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]")).getText();
System.out.println(message);
driver.findElement(By.linkText("LogOut")).click();
									}
WRITE
	//Get the current row where the data has to be written
Row newRow = getSheet.getRow(i);		//IN LOOP
	//Set the value in the cell
cell.setCellValue(DashboardMessage);	//IN LOOP
	//Create an output stream with the location where the file has to be created
FileOutputStream fileOutputStream = new FileOutputStream(filePath);
	//Close the workbook
workbook.close();

 ---------------------------------------------SCREENSHOT
 		//Typecast the driver reference variable with TakesScreenshot for access the methods from TakesScreenshot interface
		//getScreenshotAs method will take arguement for the output type of the file
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Using the FileUtils class copy the generated screenshot file to any location
FileUtils.copyFile(scrFile, new File("C:\\Users\\some_user\\Desktop\\Image.png"));	//.jpg or .png method
OR 
TakesScreenshot scrShot = (TakesScreenshot) driver;
File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
File destFile = new File(".\\Screenshot\\screenshot.png"); //System.currentTimeMillis()
FileUtils.copyFile(srcFile, destFile);
//Adding Apache POI will remove error of fileutils 
 
------------------------------------------------ EXCEPTION HANDLING 
//A good automation script is one which does not require any manual intervention from start to finish. 
//Even if there are errors occuring during execution, the script must be capable of automatically resolving 
//or bypassing that error and run to completion.
EXCEPTION: 
			ArrayOutOfBoundsException
			NullPointerException
			AirthmeticException
			NoSuchElementException
HANDLING: 
			Try/catch block
			Throw keyword : used to pass the exception caught in try to catch block
			Throw keyword : used to pass the exception to catch block outside the current method.
			Catch block: carries statement to handle the exception
			Final block: carries statement to execute irresp of exception caught or not 
		// Check for the file creation usign try-catch block
try{FileUtils.copyFile(scrFile, new File("C:\\Users\\some_user\\Desktop\\Image.png"));
	} catch(IOException e){System.out.println("Exception Message: " + e.getMessage());}
	
		


*/