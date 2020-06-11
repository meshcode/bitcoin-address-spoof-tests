# Bitcoin Address Spoof Tests

[![Build Status](https://travis-ci.org/meshcode/bitcoin-address-spoof-tests.svg?branch=master)](https://travis-ci.org/meshcode/bitcoin-address-spoof-tests)

A test for bitcoin address spoofing: Java HTTP server deploys an HTML webpage with a CSS DIV element containing a bitcoin address. Testing to see if a man-in-the-middle attack may have swapped the address for another.
## Contents
* [Purpose](#purpose)
* [Solution](#solution)
* [Built with](#built-with)
* [Screenshots](#screenshots)

## Purpose
#### To practice coding an automated maintenance test which supports the personal development of tools for financial sovereignty.
``` 
Display a bitcoin address on web page:
   1. Start Java HTTP Server
   2. Load a basic HTML/CSS webpage 
   3. Include DIV tag with bitcoin address
   4. Check if page loaded correctly at local IP
   5. Check if page is displaying content
   6. Check if the bitcoin address is correct
 ```
 
## Solution  
  - The Main.java file calls:
  - the Java HTTP server to start with pre-built HTML page.
  - Use Selenium Webdriver for Chrome to test on CHrome browser.
  - Use Gherkin to create acceptance tests for visual
  
## Built With
###### App
  - Java and HTML - using IntelliJ IDE
###### Tests
  - [Cucumber](https://cucumber.io/) - IntelliJ plugin
  - [Gherkin](https://cucumber.io/docs/gherkin/) - IntelliJ plugin
  - [TravisCI](https://travis-ci.org/) - Continuous Integration
  
## Screenshots  
  
  ###### Main app window in Chrome browser
  ![App](https://i.imgur.com/EUz1tTe.png)
  ###### Cucumber / Gherkin test process within IntelliJ
  ![Test](https://i.imgur.com/Ftc07nU.png)

  
  