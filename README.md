# sel-java-lite

## Why the framework was created?
When working on personal projects, we may often come across situations where we need a quick start framework which implements the basic components but doesn't overdo things and make it too complex to customize. The idea behind _**selenium-java-lite**_ - a lightweight selenium-java based UI automation framework is to do exactly that. While it implements the necessary components for a personal project, it keeps it simple and flexible to be customized and re-configured as per needs.


## How this is useful?
Consider this as a starting point for a larger project. It has the essential components (of course, not all) for an UI automation project. Extend it as needed.
Examples:
- Run in firefox/edge instead of chrome? - update the config.properties.
- Add more pages/tests? - just create the classes.
- Add more tests? - create more @Test methods in your test classes.
- Run multi tests/run tests in parallel? - configure in testng.xml
- Want more control over test runs? - configure testng.xml and/or pom.xml.
- Run via maven? - use maven commands from CLI
- Run via jenkins? - create a jenkins job, trigger via maven commands/auto-trigger based on GIT commits, its all possible.
- Want logs in a separate file for each run? - configure in log4j2.xml.


## How to get started?
Start by [Forking](https://docs.github.com/en/get-started/quickstart/fork-a-repo) the repository.


## What are the components of the framework?
Below are the tech-stack used:

**Maven**
- manage dependencies and plugins, integrate with CI/CD tools

**TestNG**
- test configurations in testng.xml, annotations, data provider, listeners - e.g. capturing screenshot on failure

**Properties file**
- maintain global properties

**POM**
- test pages, page objects, page factory

**Tests**
- separate driver config - uses WebDriverManager
- separate utilities class
- multi data (using testng data provider) extendable horizontally and vertically
- multi browser (using properties)

**Log4j2**
- for logging (both console and file)

**GIT**
- integration options

**Jenkins**
- integration options

**Reports**
- native testng report and surefire-reports included
- can be extended to Extent/Allure reports


## How this can be extended further?
- cloud integration (BrowserStack, SauceLabs etc.)
- data management in Excel, DB using Apache POI, JDBC
