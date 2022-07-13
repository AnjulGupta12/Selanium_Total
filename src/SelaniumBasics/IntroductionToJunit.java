/*
 		WHAT WE GONNA LEARN
 How to create a simple automation script
		Language binding
		Unit testing framework (JUnit)
		WebDriver interface
		WebElement interface – interactions with text boxes, buttons and links
		Assertion methods in JUnit
 How to automate simple interactions
		Test synchronization
		Interactions with checkboxes, radio buttons, dropdown lists, web tables and frames
 How to automate complex interactions
		Multiple browser tabs
		Popup windows
		Drag and Drop
		AJAX controls
		Dynamic web elements
 How to enhance automation scripts
		Parameterization
		Screenshot capture
		Exception handling
 How to create a test suite
		Test suite annotations

 CREATE A SIMPLE AUTOMATION SCRIPT
 README: 
		AGENDA:
			1.WHAT IS Junit Framework?
			2.How to configure Junit Framework
			3.Working with different annotations and assertion commands 
			
	Junit is an open-source unit testing framework which is used to write and run the repeatable test 
	To execute a Junit test you don't need to define the main method or create a class object 
	Annotations of Junit are used to run the test method.
	Junit provides an assertion library which is used to evaluate the test result 
	Junit is also used to run the Automation suite having multiple test cases.
	Junit Framework library is by default present in eclipse
			ANNOTATION
					@Test 	: to run Junit test 
					@Before : before each test 
					@After 	: after each test
					@BeforeClass :	before running all test 
					@AfterClass :	after executing all the test
					@Parameter :	it is tag which is used to pass multiple data 
			ASSERTIONS 
				step that validate whether web elements in the page arebehaving as expected
					Assert.assertEqual("expected value","actual value");: to check both values are same and fails if both are not equal
					Assert.assertTrue("message",condition);				: returns true if condition true and fails if false
					Assert.assertFalse("message",condition);			: returns true if condition is false and fails if true 
					Assert.assertNull(object);
					Assert.assertNotNull(object);						: return true if object not null
*/

package SelaniumBasics;

import java.time.Duration;

//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import junit.framework.Assert;

public class IntroductionToJunit {
	
	
	static WebDriver driver; 
	/*SHOULD BE IN LOCAL METHOD
	driver.get();				:loads url 
	  	  .navigate();			:access browser history and navigate to given url
	  	  .getTitle();			:fetch title of current web page
	  	  .getCurrentUrl();		:fetch url of current web page
	  	  .getPageSource();		:fetch page source
	  	  .findElement();		:locate web element 	using locator mechanism
	  	  .findElements();		:locate all web element using locator mechanism
	  	  .getWindowHandles();	:returns set of all browser windows 
	  	  .getWindowHandle();	:return unique browser window to identify the elements and work with them 
	  	  .close();				:close active browse window 
	  	  .quit();				:quits webdriver instance and close all browser windows.
	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		String url="https://www.facebook.com/login.php";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	/*IMPLICIT WAIT : driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  THIS COULD BE MINUTE, MILISECOND, MICROSECOND,DAYS, HOUR, EXTRA 
	  						generic timeout setting 
	  						Drawback: It is applied to all the steps(WHAT DO YOU MEAN BY ALL THE STEPS!!!!!!!!!!!!!!!!) in the script 	
	  						 //	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	  						
	EXPLICIT WAIT : WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
							wait only for specific element based on condition 
							'util' method of'wait' obj, to wait until element identified by id(someid) 
							ExpectedCondition is class, carries predefined condition
							//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
							//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.
							 			xpath("//*[@id=\"root\"]/div[2]/div/section[2]/div/div/div[1]/div/div[1]/div[2]/div[1]/div[1]/div[2]/h4")));
							 
	*/
		
	}
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	
	
	
	
	@Before
	public void setUp() throws Exception {
		WebElement userLoc = driver.findElement(By.id("email"));		
		WebElement passwordLoc= driver.findElement(By.id("pass"));
		WebElement loginLoc = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
		
				userLoc.sendKeys("anjulgupta1205@gmail.com");
				passwordLoc.sendKeys("Anjul12$$");
				loginLoc.click();
	/* LOCATOR: command that tells Selanium which element needs to be ooperated on(8 known ) 
	 			ID, Name, Classname, LinkText, PartialLinkText, CSSSelector, Xpath, TagName
	 			
	 			driver.findElement(By.locator());			//Find the single Web element 
	 		AND	driver.findElements(By.locator());			//Returns the list of WebElements
	 			
	 			className : attribute specified in class By.className("buttonStyle")!!!!!!!!!!
	 			LinkText : links will be enclosed in <a>tag of HTML
	 			CSSSelector !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 			TagName !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 			
	  * WORKING WITH HTML ELEMENTS
	  			.clear()				 : clr the value of text area element
	  			.sendKeys("<test data>") : for input the test data(interect with textbox)
	  			.click()				 : click button(interect with button)
	  			.isDisplayed()			 : boolean function, show element is visible or not 
	  			.isEnabled()			 : boolean function, show element is enabled or not
	  			.isSelected()			 : boolean function, check weather item is in checkbox, drop down list or radio button element is selected or not
	  			.submit()				 : works better with click(), if element is a form or element, to be clicked within a form 
	  			.getText()				 : fetch visible text of an element 
	  			.getTagName()			 : fetch tag name 
	  			.getCssValue()			 : fetch css property value 
	  			.getSize()				 : fetch width and height of element 
	  			.getLocation()			 : fetch x & y coordinate from app screen
	  */
	}
	
	/* when to select relative or absolute xpath?
			Absolute (start with / ) :: eg: /html/body/div[2]/div/div/footer/section[3]/div/ul/li[3]/a 
						will need to be present 100% of time, there is good chance it will vary in each release
						
			Relative (start with //) :: eg: //*[@id=’social-media’]/ul/li[3]/a
						path start form node of your choice, need not to be from root node. 
						It's better to choose this as it reduces the chance of element not found
						  
						"/" signifies to look for element immediately inside its parent 
						"//" signifies to look for any child element inside the parent element  
			Custom :: eg: //tag_name[@attribute=’value’]
						 you can design your own xpath using different attributes of the web element 
	*/	

	@After
	public void tearDown() throws Exception {
		WebElement elem = driver.findElement(By.xpath("xpath copied from inspect console window"));
		Actions act = new Actions(driver);
		act.moveToElement(elem).build().perform();
		driver.findElement(By.linkText("LogOut")).click();
	}
	//By. is not being inspected from website so it must generate error
	
	
	@Test
	public void test() {
		WebElement transaction = driver.findElement(By.xpath("xpath copied from inspect console window"));
		Assert.assertEquals("View Transaction", transaction.getText());
	}// Expalin this transaction window
	//By. is not being inspected from website so it must generate error

}
/*
package com.test;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
 
public class Demo02_WorkingWithBrowser {
 
	WebDriver driver;
	String url = "http://localhost:8080/PackAndGo_v2/index.html";
 
	@Before
	public void setUp() {
							//Set the key/value property according to the browser you are using.
      System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe"); 
 
  						    //Open browser instance
    driver = new FirefoxDriver();
		
							//Open the AUT
		driver.get(url);
	}
 
	@Test
	public void test() {
							//Fetch the page title
		String pageTitle = driver.getTitle();
		System.out.println("Page title: " + pageTitle);
	}
 
	@After
	public void tearDown() {
							//Close the browser
		driver.close();
	}
}









*/
