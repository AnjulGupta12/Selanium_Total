package SelaniumAdv;

public class Maven {

}
/*
MAVEN

 build automation tool 
 uses convention over configuration 
 means developers are not required to create build process themselves
 provides sensible default behavior for projects

Problem face during project development:
	Adding set of Jars in each project
	Dependencies and Versions 

POM in Maven stands for Project Object Model.
It is fundamental Unit of Work in Maven. 
It is an XML file which resides in the base directory of the project as pom.xml. 
The POM contains information about the project and various configuration detail used by Maven to build the projects.
POM also contains the goals and plugins. 
While executing a task or goal, Maven looks for the POM in the current directory. 
It reads the POM, gets the needed configuration information, then executes the goal.

A maven repository is a directory of packaged JAR file with pom.xml file. 
Maven searches for dependencies in the repositories. 
There are 3 types of maven repository:
	Local Repository	->	Central Repository	->	Remote Repository
located in 	
	(into local system)	->	(on the web)		-> 	(on the web)




*/