//ANNOTATION OF JUNIT TEST CASE 4 
// @Test, @Before, @After, @BeforeClass, @AfterClass
/*
 					@Test 	: to run Junit test 
					@Before : before each test 
					@After 	: after each test
					@BeforeClass :	before running all test 
					@AfterClass :	after executing all the test
					@Parameter :	it is tag which is used to pass multiple data 
 */

package SelaniumBasics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationOfJUnit {

	@BeforeClass
	//RUN ONLY ONCE BEFORE ANY OTHER METHOD IN THE CLASS IS EXECUTED 
	public static void beforeClass() {
		System.out.println("Inside before class method.");
	}

	@AfterClass
	// RUN ONLY ONCE AFTER ANY OTHER METHOD IN THE CLASS IS EXECUTED 
	public static void afterClass() {
		System.out.println("Inside after class method.");
	}

	@Before 
	//RUN ONLY ONCE BEFORE EXEFCUTING EVERY @TEST METHOD IN THE CLASSS
	public void before() {
		System.out.println("Inside before method.");
	}

	@After 
	//RUN ONLY ONCE AFTER EXECUTINNG EVERY @TEST METHOD IN THE CLASS
	public void after() {
		System.out.println("Inside affter method.");
	}

	@Test 
	//FOR EVERY TEST CASE
	public void test() {
		System.out.println("Inside test method.");		
	}

}
