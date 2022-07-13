/*
		AUTOMATE COMPLEX INTERACTION
				1.Automate interactions with multiple browser tab.
				2. Automate interactions with pop-up messages and prompts.
				3. Automate interactions with web elements enable for drag-and-drop.
				4. Automate interactions with web elements using AJAX controls.
				5. Automate interactions with dynamic web elements.
		
*/
package Automate_simple_interactions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Calendar;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class AutomationComplexInteractions {
	public static WebDriver driver;
	static String url = "http://localhost:8080/EDUBank/tellerLogin/";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Set the key/value property according to the browser you are using.
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

		// Open browser instance
		driver = new ChromeDriver();

		// Open the AUT
		driver.get(url);

		// Declare an implicit wait which is bounded to WebDriver instance
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// Close the driver
		driver.close();

	}


	@Test
	void test() {
		// Enter username
		driver.findElement(By.id("tellerId")).sendKeys("T7302");

		// Enter password
		driver.findElement(By.id("password")).sendKeys("T7302*abc");

		// Click on Login button
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();

		// Enter name
		driver.findElement(By.id("custName")).sendKeys("John");

		// Enter EmailId
		driver.findElement(By.id("email")).sendKeys("johnwin" + Calendar.getInstance().getTime().getTime() + "@gmail.com");
		

		// Enter dateofBirth
		driver.findElement(By.id("dob")).sendKeys("21/10/1987");

		/// Find the security Question DROPDOWN list and store it as a WebElement
		WebElement sectyq = driver.findElement(By.id("secQId"));

		// Pass the reference variable for sectyq as a parameter for the Select class
		Select secqdd = new Select(sectyq);

		// Use the select reference variable for selecting any option using
		// index/value/visible text approach
		secqdd.selectByValue("210002");

		// Enter the security answer
		driver.findElement(By.id("secAns")).sendKeys("Chicago");

		// Click on Add Customer
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/form/button[1]")).click();

		// Click on Download Customer Details
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/a")).click();

		// Fetch the number of opened windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: " + windowHandles.size());

		Integer temp = 0;

		String msg = null;

		// Iterate through all the available windows
		for (String string : windowHandles) {
			// Switch between windows using the string reference variable
			driver.switchTo().window(string);
		
			// Fetch the url of the page post successful switch
			String title = driver.getTitle();

			// check whether the url post switch is the desired page
			if (!title.equals("Teller Home")) {
				temp = 1;
				msg = "Window found.";
				break;
			} else {
				temp = 0;
			}
		}

		if (temp == 1) {

			System.out.println(msg);

			// Find some element from the switched page to verify that the switch is
			// successful
			WebElement Bankname = driver.findElement(By.xpath("/html/body/div/span[1]"));
			System.out.println(Bankname.getText() + " Bank");
		} else if (temp == 0) {
			System.out.println("Desired Window not found.");
		}

		
		//DRAG AND DROP
		
				//Fetch the element property which should be dragged by using element locator
				WebElement fromElement = driver.findElement(By.id("draggable"));
				
				//Fetch the element property where the dragged element should get released by using element locator
				WebElement toElement = driver.findElement(By.id("droppable"));
				
				//Create a reference for Actions class
				Actions action = new Actions(driver);
				
				//Use dragAndDrop method and provide arguements as the from element and to element
				action.dragAndDrop(fromElement, toElement).perform();
				
				//Post drag fetch the status message and compare for successful verification
				String afterDragging = driver.findElement(By.xpath("html/body/form/div[4]/div/div[2]/div/p")).getText();
				
				if(afterDragging.equals("Dropped!"))
					System.out.println("Drag successful.");
				else
					System.out.println("Drag Unsuccessful.");
			
		 
	}

}
/*
	1. AUTOMATE INTERACTIONS WITH MULTIPLE BROWSE TABS 
		// Fetch the number of opened windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: " + windowHandles.size());
		
		
		Integer temp = 0;
		String msg = null;

			// Iterate through all the available windows
			for (String string1 : windowHandles) 
			{
				// Switch between windows using the string reference variable
				driver.switchTo().window(string1);
		
				// Fetch the url of the page post successful switch
				String title = driver.getTitle();
				//String url = driver.getCurrentUrl();

				// check whether the url post switch is the desired page
							//if(url.equals("www.tellerhomes.com")) //
				if (!title.equals("Teller Home")) {
						temp = 1;
						msg = "Window found.";
						break;
						} 
				else {temp = 0;}
			}

		if (temp == 1) 
		{	System.out.println(msg);
			// Find some element from the switched page to verify that the switch is
			// successful
			WebElement Bankname = driver.findElement(By.xpath("/html/body/div/span[1]"));
			System.out.println(Bankname.getText() + " Bank");
		}
		else if (temp == 0) {System.out.println("Desired Window not found.");}

	2.AUTOMATED INTERACTION WITH POP-UP MESSAGE AAND PROMPTS
 		POP UP: Usually has only OK and CANCEL buttons 
 		Prompts: Expects an input from user
		Confirmation: Ask for conformation using buttons like ACCEPT, REJECT, YES, NO, ABORT, RETRY, etc.
 			//Dismiss the alert
			driver.switchTo().alert().dismiss();
			//Accept the alert box
			driver.switchTo().alert().accept();
			//To enter text in prompt box 
			driver.switchTo().alert().sendKeys("Anjul");
		
	3. AUTOMATE INTERACTION WITH DRAG AND DROP
			New feature in HTML5
				WebElement fromElement = driver.findElement(By.id("draggable"));
				WebElement toElement = driver.findElement(By.id("droppable"));
				
				//Create a reference for Actions class
				Actions action = new Actions(driver);
				
				//Use dragAndDrop method and provide arguements as the from element and to element
				action.dragAndDrop(fromElement, toElement).perform();
				
				String afterDragging = driver.findElement(By.xpath("html/body/form/div[4]/div/div[2]/div/p")).getText();
				if(afterDragging.equals("Dropped!"))
					System.out.println("Drag successful.");
				else
					System.out.println("Drag Unsuccessful.");
			
	4. 	AUTOMATE INTERACTION WITH WEB ELEMENT USING AJAX CONTROLS 
			for eg we hover mouse over like button there are series of pop up emoji 
				WebElement linkEmployee = driver.findElement(By.xpath("html/body/form/div[6]/div/div[1]"));
				WebElement linkDetails = driver.findElement(By.xpath("html/body/form/div[6]/div/div[1]/a"));
						
				//Use the action class to 
				Actions action = new Actions(driver);
				action.moveToElement(linkEmployee).moveToElement(linkDetails).click().build().perform();
				// since it is a follow of path action so build() and perform() that all method
	5. 	AUTOMATE INTERACTION WITH DYNAMIC WEB ELEMENTS
			 	Each and everyday with different use web elements do change on website(dynamic web pages) is called dynamic web elements.
			 	Don't use xpath locator in this case 'cuz they can change with different requirement, rather we can use id locator.
			 	Expected Condition Strategies: 
			 	1. visibilityOfAllElementsLocatedBy()
			 	2. elementToBeClickable()
			 	3. elementToBeSelected()
			 	4. frameToBeAvailableAndSwitchToIt()
			 	5. presenceOfAllElementsLocatedBy()
			 	6. alertIsPresent()
			 	
	
	
			 	
			 	
			 	
			 	
				
 	
 
 */