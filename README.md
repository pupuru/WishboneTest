# WishboneTest
This is a test automation framework for Sign up and Sign in pages of https://www.wishbone.pl/ site. It's built using Java, Selenium webdriver, TestNG and Gradle.

# Installation

1. Make sure you have newest versions of Java and Chromedriver installed and added to the PATH variable on your system. 
[I've added dependencies for java and webdriver in my build.gradle file, but the PATH variable may cause some problems, so in that case it's safer to install the binaries.]
2. Install newest Intellij IDE.
3. Clone url of this repository (https://github.com/pupuru/WishboneTest.git).
4. Open Intellij and choose 'Get from version control' option.
5. Paste the copied URL, choose location for the project and click 'Clone'.
6. Wait a moment for the project to build.

# Running tests
To run tests simply open WishboneTest/src from the project structure, right-click on 'test' folder and choose 'Run Tests in Wishbonete...'. To run them individually: open test/java folder, choose java class with tests you want to run and then rightclick on @Test tag to choose 'Run...' from the menu.
OR: Open Gradle options (farthest to the right in Intellij), click the 'Reload all gradle projects' icon and still in the gradle options open WishboneTest/Run Configurations and double click on the test you want to run.

# Opening reports
To view report created by running test open the project folder and go to /build/reports/tests/test/index.html
