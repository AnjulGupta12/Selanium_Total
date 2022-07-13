package SelaniumAdv;

public class Log4j {

}
/*
LOG REPORT USING LOG 4J
	Principal components:
		A.Logger 
			1.is responsible for logging information’s provided by test script creator.
			2.have five kinds of log levels FATAL, ERROR, WARN, INFO and DEBUG.
		B.Layout
			is responsible for formatting logging information in different styles.
		C.Appender
			is responsible for writing log messages.
			are of three types such as:
				ConsoleAppender used to log standard output in console.
				FileAppender used to write logs into files.
				RollingFileAppender extends FileAppender to backup log files when they reach their maximum size.

Layout
//Apache Log4j is a Java based reliable, fast and flexible logging utility 
//which is used for logging execution information.			
		
Logger
//OFF	:to turn off logging  
//FATAL	: print sever msg that cause app crash
//ERROR	: print runtime error or unexpected cond. 
//WARN	: print info regarding unexpected system behaviour 
//INFO	: print info message regarding progress of test scripts execution 
//DEBUG	: print the debugging message for test script dev stages
//ALL	: log all the details
 	log.info("Info Message!");
	log.error("Error Message!");

 	
 	CONVERSION CHARACTERS BY Apache Log4j
 			to specify a pattern for the log messages conversion character are used.
 			Preceded by % symbol 
 			Like :	 [%p] %c %M - %m%n
 	c	: Used to end the category of the legging event
	C	: Used to output the hilly qualified dass name asung logging request
	d	: Used to outpot the date of the logging event
	F	: Used to output the file name issuing logging request
	l	: Used to elput location information of the caller cless issuing logging event.
	L	: Used to output the line number from where the logging request was issued
	m	: Used to output the application supplied message associated with the logging event
	M	: Used to output the method name where the logging request was issued
	n	: Used to output the platform dependent line separator character or characters.
	p	: Used to output the priority of the logging event
	r	: Used to put the number of miseconds elapsed from the construction of the layout until the creation of the logging event
	t	: Used to output the name of the thread that generated the logging event
	x	: Used to output the nested diagnostic context associated with the thread that generated the logging event
	X	: Used to output the mapped diagnostic context associated with the thread that generated the logging event
	%	: The sequence %% outputs a single percent sign

 Log4j can be configured as 
 			 Basic Configurator
			.property
			.xml		

static Logger logger = Logger.getLogger("Demo16_Basic_Configurator.class");
    public static void main(String[] args)throws Exception {
        WebDriver driver;
    BasicConfigurator.configure();
  
    driver.get("http://10.67.89.41/Automation/PackAndGo_v2/index.html");
    logger.info("Opening Pack and Go application");
  
  //clicking on Login button
  driver.findElement(By.xpath("//*[@id=\'myNavbar\']/ul/li[4]/a")).click();
 
  //entering username
  driver.findElement(By.id("usernameLogin")).sendKeys("pgGru");
  logger.info("Entering Username");
  
  //entering password
  driver.findElement(By.id("passwordLogin")).sendKeys("freezeray");
  logger.info("Entering Password");
  
  //clicking on login button 
  driver.findElement(By.id("login")).click();
  logger.info("Click on Login button");
 
  //clicking on logout button
  driver.findElement(By.id("topMenu2")).click();
  logger.info("Logout from the application");
  
  driver.quit();
 
    }

LOG4J IS NOT MY CUP OF COFFEE


*/