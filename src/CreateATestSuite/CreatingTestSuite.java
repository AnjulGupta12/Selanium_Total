package CreateATestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class CreatingTestSuite {

}
/*
 
@RunWith(Suite.class)
@SuiteClasses({})
public class CreatingTestSuite { }

CREATE A TEST SUITE 
 for multiple test case file working one by one 
@RunWith	:  Junit invokes class it references to run the tests in that class instead of the runner built into JUnit.
@SuiteClasses : the classes to be run when a class annotated with @RunWith(Suite.class) is run

//@SuiteClass with the .class file name which needs to run as a suite
@SuiteClasses({ Demo03_LoginLogOut.class, Demo04_AssertWelcomeMessage.class, Demo10_ExcelReading.class })
public class Demo14_TestSuite {
}
*/