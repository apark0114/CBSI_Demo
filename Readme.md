# CBSI Selenium-Webdriver Demo

### What you need to get started.
1. Eclipse IDE (https://eclipse.org/downloads/)
2. Maven 3
3. Maven plugin (for eclipse) 
4. Firefox browser

### Import this project to eclipse.
1. Download this project from Git-hub.
2. Eclipse menu bar -> File -> Import -> Maven -> Existing maven project.
3. Browse to the directory of the project where pom.xml is located.
4. click finish.

### Run tests in Eclipse IDE
1. Expand src/test/java folder.
2. Expand the only package (cbsi_webdriver_demo1.cbsi_webdriver_demo1)
3. Open the java file (cbsNewsSanityTest).
4. Eclipse menu bar -> Run -> Run.
5. This should run methods with @Test annotation. 
6. The test result will be shown in JUnit side panel.

### Run tests on command line.
1. Navigate to your project directory where pom.xml file is.
2. Type "mvn clean test".
3. Maven should pick up all java files named "--Test".
4. Once finished it should show a report of the test result.

