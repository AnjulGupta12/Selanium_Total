/*						AUTOMATE SIMPLE INTERACTIONS
 		wait until AUT is ready to receive the instruction from the test step
 		WHY?
 		it will throw exceptions like NoSuchElementException ElementNotVisibleException
 		cuz that particular website need time to open 
 		
 		
 		Different type of web element
 					  a. text box 	
 					  b. button		
 					  c. radio button 	
 					  d. check boxes
 					  e. link
 					  f. image, image link, image button
 					  g. drop down list
 */
package Automate_simple_interactions;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateInteractions {
	
	WebDriver driver;
	String url = "http://localhost:8080/PackAndGo_v2/index.html";

	@Before
	public void setUp() throws Exception {
		//Set the key/value property according to the browser you are using.
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe"); 
				 
		//Open browser instance
		driver = new ChromeDriver();
						
		//Open the AUT
		driver.get(url);
		
		//Declare an implicit wait which is bounded to WebDriver instance
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			//5000, TimeUnit.MILLISECONDS is past version
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException{
		//Click on Login
		driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[4]/a")).click();		
			
		Thread.sleep(2000);
		//Enter the username
		driver.findElement(By.id("usernameLogin")).sendKeys("pgGru");
		/* 
		 
		 TEXT BOX
		 .sendKeys()		enter a value
		 .clear()			clear the field
		 .click() or .submit()  for click operation
		 
		 RADIO BUTTON & CHECK BOX
		 OPERATION : RADIO BUTTON : 1.Select  2.isEnabled  3.isDisplayed  4.isSelected
		 				System.out.println(vegradio.isEnabled());
		 				vegradio.click();
		 				System.out.println(nonvegradio.isDisplayed());
		 				if(nonvegradio.isSelected()==false)
		 					nonvegradio.click();
		 			
		 OPERATION : CHECK BOX : 1.select  2.Unselect
		 				System.out.println(checkbox1.isDisplayed());
		 				System.out.println(checkbox1.isEnabled());
		 				checkbox1.click();
		 				if(checkbox1.isSelected()==false)
		 					checkbox1.click(); 
		
		OPERATION : DROP DOWN: 1.selectByVisibleText() 2.deselectByVisibleText() 3.selectByValue() 4.deselectByValue() 5.selectByIndex() 6.deselectByIndex() 7. isMultiple() 8.deselectAll()
		 				i would prefer sir's method .sendKeys(Keys.__________()); method
		
		OPERATION : LINK : 1. click()
		 				driver.findElement(By.linkText("Offers")).click();
		 				context() click is right click 
		 			
		
		OPERATION : TABLE : TOO COMPLICATED IN LEX ASK TO SIR TO EXPLAIN!!!!!!!!!!!!!!!!!!!! 
						sir's method in another junit test
		OPERATION : FRAMES : defined with FRAMESET and FRAME tag in HTML
						driver.switchTo().frame(1);			//switch to frame using index number
						driver,switchTo().parentFrame();	//switch back to parent frame 
						driver.switchTo().frame("right")	// switch to another frame using frame name 
		  */
			
		//Enter the password
		driver.findElement(By.id("passwordLogin")).sendKeys("freezeray");
			
		//Click on Login button
		driver.findElement(By.id("login")).click();
		
		//Find the From DROPDOWN LIST and store it as a WebElement
		WebElement fromsrc = driver.findElement(By.id("fromDD"));
			
		Select selectFrom = new Select(fromsrc);
		//Use the select reference variable for SELECTING any option using INDEX/value/visible text approach
		//Index starts with 0
		selectFrom.selectByIndex(1);
		
		/* OR
		collecting line no 72 74 and 77 using Key. in sendKeys
		
		//SELECT LOCATION FROM SEARCH LABEL
		WebElement var = driver.findElement(By.xpath("//*[@id=\"downshift-1-input\"]"));
				
		var.sendKeys("Chennai");
		var.sendKeys(Keys.ARROW_DOWN);		//Choose from drop down
		Thread.sleep(2000);
		var.sendKeys(Keys.ENTER);			// pressing enter to the choosen one 
		 */
		
		//Find the To dropdown list and store it as a WebElement
		WebElement toDest = driver.findElement(By.id("toDD"));
				
		//Pass the reference variable for toDest as a parameter for the Select class
		Select selectTo = new Select(toDest);
		
		//Use the select reference variable for selecting any option using index/value/visible text approach
		selectTo.selectByValue("Hyderabad");
		
		//click on Search Buses button
		driver.findElement(By.id("searchBus")).click();
		
		//RADIO BUTTON
		
		//Select the Radio button Search Bus corresponding to BNGHYD2200
		driver.findElement(By.id("radio3")).click();

		//Select the Proceed to Booking button
		driver.findElement(By.id("book")).click();	
	}
}

//what is 
/*
driver.navigate().refresh()   to refresh

*/