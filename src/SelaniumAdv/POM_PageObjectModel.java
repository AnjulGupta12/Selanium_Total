package SelaniumAdv;

public class POM_PageObjectModel {

}

/*
-------------------POM_Page_Object_Model
Page Object Model(POM) is a design pattern to create Object Repository for web UI elements.

	The key points about Page Object Model: 
		1.The page object class contains the following:
				Variables storing the web element attribute type and value. 
				Methods for various interaction with the web page. 
		2.Base class which contains the following:
				Method to initialize WebDriver instances.
				Methods to terminate WebDriver instances.
		3.Testcase class contains test methods to invoke the different methods in page objects class. The following points need to be kept in mind:
				Objects for different page object class is created and the methods for various interactions are invoked.
				Whenever there is a method to click on a button or a link, you should return the object to the next page from the method. 

The key points about page object model project execution :
		1.Multiple tests can be grouped under a single suite tag.
		2.Multiple tests can be executed in parallel by configuring the thread-count and parallel attributes within suite tag.
		3.Each test tag inside the suite should have a unique value for name attribute. 
		4.Every TestNG test execution creates an index.html file inside test-output folder which contains the following: 
					The name of the tests which got executed.
					Time taken for the execution of each test.
					Exception details for the failed test method.
					Execution status of each test script.  
					Groups which got executed.






*/