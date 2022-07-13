/*
  TestNG
	 Ability to produce HTML Reports after every test execution (Selenium doesn’t have the capability to generate reports)
	 Annotations makes the methods easier to differentiate
	 Grouping and prioritization of tests can be done to control execution flow of test cases   
	 Data can be Parameterized using different built-in annotations	
	 Parallel execution of test methods is possible
	 
	Assert. 	: HARD assert : test script will stop executing when the assertion fails	
	softAssert.	: SOFT assert : test execution continues even if an assertion statement fails in the test script
	 		.assertEqual(String actual, string expected)
	 		.assertTrue(boolean condition)
	 		.assertFalse(boolean condition)
 	 method assertAll() is called after all the assertions are done.
 */

package SelaniumAdv;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGFrameWork {
	WebDriver driver;

  @Test(dataProvider = "dp") //map the DataProvider method to the test method 
  //mark class or method as a part of the test 
  /*
  1. dependsOnMethod	: to execute method based on its dependent method.
  2. Priority	  		: set priority to test method, low priority will scheduled first mns 1 first then 2 
  3. Enabled			: If test method to execute, value = true else false 
  4. Groups 			: club several test methods under common name
  5. dataProvider		: used to provide data sets for test method parameterization
  
  
  
  */
  public void f(Integer n, String s) {System.out.println("Inside Test Method");}
 
  //FOR dependsOnMethod 
  
  @Test
  public void login() 
  {
      System.out.println("Code to login into the AUT");
  }
  @Test(dependsOnMethods = { "login" })
  public void dashboard()
  {
      System.out.println("Dashboard Page");
  }		//if login method is successful then it goes to dashboard
 @Test(dependsOnMethods = { "dashboard" })
  public void logout() 
  {
      System.out.println("Logout from the application");
  }		// if dashboard method is successful then it goes to this logout method 
 
 
 //FOR priority 
 @Test(priority = 2,enabled=false)
 public void test01() 
 {
     System.out.println("Inside Test01 Method");
 }
 @Test(priority = 0)
 public void test02() 
 {
     System.out.println("Inside Test02 Method");
 }
 @Test(priority = 1)
 public void test03()
 {
     System.out.println("Inside Test03 Method");
 }
// The method test02() should get executed first and the method test01() should not get executed. 
 
 
 //FOR groups
//car,ecar,sedan belongs to a module called as car
 @Test(groups = { "car", "ecar" })            
 public void car() {
     System.out.println("Car");
 }
@Test(groups = { "car", "sedan" })
 public void car1() {
     System.out.println("Car1");
 }
@Test(groups = { "car" })
 public void car2() {
     System.out.println("Car2");
 }



  
  @BeforeMethod					//before each test method 
  public void beforeMethod() {System.out.println("Inside Before Method");  }

  @AfterMethod
  public void afterMethod() { System.out.println("Inside After Method");  }

  @DataProvider(name = "credential")	//naming the data provider 
  //used to supply data to test method 
  //must return an Object[m][n]  : m=no of sets of data  &  n=no of parameter to be passed
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
    //used to run the test method multiple times with different sets of test data. 
    //The method which has the logic to fetch the data and arrange the same will be annotated
   // annotation and the attribute dataProvider will be used to link the test method and dataprovider method.   
  }
  
  @DataProvider(name = "credential2")
  public Object[][]getData() {
      Object[][]data=new Object[2][2];
      data[0][0]="pgGru";
      data[0][1]="freezeray";
      data[1][0]="pgAlmacho";
      data[1][1]="freezeray";
      return data;	
  }
  
  @BeforeClass					//before first test method in current class
  public void beforeClass() { System.out.println("Inside After Method");  }

  @AfterClass
  public void afterClass() {  System.out.println("Inside AfterClass Method");  }

  @BeforeTest					//before any test method 
  public void beforeTest() {  System.out.println("Inside BeforeTest Method");  }

  @AfterTest
  public void afterTest() {  System.out.println("Inside AfterTest Method");  }

  @BeforeSuite					//Before all test inside test suite.
  public void beforeSuite() {  System.out.println("Inside BeforeSuite Method");  }

  @AfterSuite
  public void afterSuite() {   System.out.println("Inside AfterSuite Method");  }

  //@Parameter
  //used to fetch simple parameter defined in testng.xml
  
  @Parameters({"browser","URL"})
  public void Setup(@Optional("Chrome")String browser1,String url) {
      System.out.println("Browser:"+browser1);
      System.out.println("AUT Link: "+url); 
  }
  
  @Parameters({ "browsername", "url" })
  public void setup(@Optional("Firefox")String browsername,String url) {	
  	switch (browsername) {
  	case "IE":
  	//Code to initialize webdriver instance
  		driver.get(url);
  		break;
  	case "Firefox":
  		//Code to initialize webdriver instance
  		driver.get(url);
  		break;
  	case "chrome":
  		//Code to initialize webdriver instance
  		driver.get(url);
  		break;	
  	}	
  
  //@Optional
  //It will take default value if no parameter is passed or the variable is not found in the testng.xml file.
} }
/*
 Inside BeforeSuite Method
Inside BeforeTest Method
Inside After Method
Inside Before Method
Car
Inside After Method
Inside Before Method
Car1
Inside After Method
Inside Before Method
Car2
Inside After Method
Inside Before Method
Code to login into the AUT
Inside After Method
Inside Before Method
Dashboard Page
Inside After Method
Inside Before Method
Logout from the application
Inside After Method
Inside Before Method
Inside Test02 Method
Inside After Method
Inside Before Method
Inside Test03 Method
Inside After Method
Inside AfterClass Method
Inside AfterTest Method
PASSED: test03
PASSED: login
PASSED: logout
PASSED: car1
PASSED: car2
PASSED: test02
PASSED: car
PASSED: dashboard
FAILED: f


===============================================
    Default test
    Tests run: 9, Failures: 1, Skips: 0
===============================================

Inside AfterSuite Method

===============================================
Default suite
Total tests run: 9, Passes: 8, Failures: 1, Skips: 0
===============================================


BeforeSuite -> BeforeTest -> BeforeClass -> BeforeMethod -> Test Method  -> AfterMethod -> AfterClass -> AfterTest -> AfterSuite
  
 
*/