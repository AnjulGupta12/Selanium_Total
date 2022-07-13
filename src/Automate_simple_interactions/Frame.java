//USELESS
package Automate_simple_interactions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frame {

		WebDriver driver;
		String url = "DemoUrl";
		@Before
		public void setUp() {
			//Set the key/value property according to the browser you are using.
			//Open browser instance
			//Open the AUT		
			//Declare an implicit wait which is bounded to WebDriver instance
		}
	 
		@Test
		public void test() {
	        // In case if you encounter frames in your application you can use the below sample codes to work with them
	        //Frames can be switched using either
	        // 1. Index
	        // 2. Name
	        // 3. Id
	        
			//Switch to the frame using the index number
			driver.switchTo().frame(1);
			
			//Post succesful try to fetch some element from the corresponding frame using any locator 
			String imageName1 = driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/span")).getText();
			System.out.println(imageName1);
			
			//Switch back to the parent frame
			driver.switchTo().parentFrame();
			
			//Try to switch to another frame using frame name
			driver.switchTo().frame("Frame_Name");
			
			//Post succesful try to fetch some element from the corresponding frame
			String imageName2 = driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/span")).getText();
			System.out.println(imageName2);
		}
	 
		@After
		public void tearDown() {
			driver.quit();
	                //Close the browser
		}
	
	}


