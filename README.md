# Assignment

[Click here to read the assignment](./docs/assignment.md)

## clipboard-recruiting-tht-sdet

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started
The code is organized into the following packages:

`src/main/java/amazon/pages`: Page classes representing different pages/components of Amazon. `BasePage` is the helper class performing the driver actions like click, findElement, etc.

`test/java/amazon`: Test class for the Amazon test

## Running the test
There are two ways to run the test:

### From IDE
Open the project & navigate to the `TestPageNavigation` class. Right-click the `assertPageNavigation` test method and select `Run` option. It takes a few seconds to start the test run

### From Terminal
Open Terminal, navigate the project root. Assuming the above dependencies are installed, run the below command to run the test:
`mvn test -Dgroups=amazonTest`
