# sel-java-lite

When working on personal projects, we may often come across situations where we need a quick start framework which implements the basic components but doesn't overdo things and make it too complex to customize. The idea behind **selenium-java-lite** - **a lightweight selenium-java based UI automation framework** is to do exactly that. While it implements the necessary components for a personal project, it keeps it simple and flexible to be customized and re-configured as per needs.

At a high level, below are the tech-stack used:

**Maven**
- manage dependencies and plugins, integrate with CI/CD tools

**TestNG**
- test configurations in testng.xml, annotations, data provider, listeners

**Properties file**
- maintain global properties

**POM**
- test pages, page objects, page factory

**Java - OOPS**
- encapsulation
- inheritance
- polymorphism
- abstraction (using interface)

**Tests**
- separate driver config - uses WebDriverManager
- separate utilities class
- multi data (using testng data provider) extendable horizontally and vertically
- multi browser (using properties and driver setup)

**Log4j2**
- for logging

**GIT**
- fully integrated

**Jenkins**
- fully integrated

**Reports**
- native testng report and surefire-reports
- didn't find a need to use Extent/Allure reports, but can be enhanced

Future enhancements/deferred for now:
- cloud integration (BrowserStack, SauceLabs etc.)
- Data Management in Excel, DB using Apache POI, JDBC
