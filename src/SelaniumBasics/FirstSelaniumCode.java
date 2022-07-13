/*
 README 
 		AGENDA 
 			1. Simple Programme to open browser 
 			2. Run and Validate the script 
 			3. Different type of navigation commands present in selanium 
 		** 
 			*Setting the driver path 
 		*Creating WebDriver instance 
 		*Navigate to WebPage
 		*Maximising the window 
 		*Retriving the WebPage Title
 		*Closing the browser session
 		*/

package SelaniumBasics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FirstSelaniumCode {
	
	@Test
	public void test() {
		
						//1.SIMPLE PROGRAMME TO OPEN BROWSER
		
		//System.setProperty("Webdriver.ie.driver",".\\SelaniumByMyself\\Drivers\\ieDriver.exe");		HERE . MEANS CURRENT FOLDER, THEN POSITION IN CURRENT FOLDER BY RIGHT CLICKING ON CHROME DRIVER AND PROPERTIES THERE YOU WILL GET THE PATH
		// SINCE I HAVE CHROME DRIVER ONLY SO ie=Chrome 
		//for firefox it is gecko
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		
		
		
		//creating webdriver instance 
		//variable name as driver 
		WebDriver driver;
		driver = new ChromeDriver();		// instanciate webdriver 
		
		
		//Navigate to webpage 
		driver.get("https://www.goibibo.com/hotels/");						//while typing driver. you will get lot of method of webdriver library .get will that url as an argument
		
		//Maximizing the window 
		//while we reach above url it might not get reach to maximize window but stays at restore window size 
		driver.manage().window().maximize(); 
		
		//Retrieving  the webpage title 
		String title = driver.getTitle();
		System.out.println("The title of the page is : "+ title );
		
		//close the browser
		//driver.close();  
		//OR
		driver.quit();
		
		
						//2. RUN AND VALIDATE THE SCRIPT
		
		/*
		 A) Using Eclipse run options ( right click-> run as->j unit test )
		 B) Shortcut key Ctrl+F11 to run entire code 
		 
		 */
		
						//3. DIFFERENT NAVIGATION COMMANDS 
		/*
		 A)  Driver.navigate.to();
		 B)  Driver.navigate.forward();
		 C)  Driver.navigate.backward();
		 D)	 Driver.navigate.refresh();
		 
		 */
		
		driver.findElement(By.linkText("About")).click();			//ERROR : there is no About button here.
		
		driver.navigate().back();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().forward();
		
		try {
			Thread.sleep(5000);					//this error can be removed by try/catch block
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		driver.navigate().to("www.ola.com");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().refresh();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
