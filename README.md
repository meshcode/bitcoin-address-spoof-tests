# Store Distance Calculator

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
We were assigned to write a simple Java program to make calculations based on the following data:
   1. Home is at location point [x = 0 y = 0]
   2. The old Żabka store is at [x = 1.2, y = 2.5]
   3. A new Biedronka store is at [x = 3.3, y=2.7]
   4. The new Żabka store replacing the old is at [x = 5.5, y = -2.3] 
   5. How far is it from home to the new stpre and closest store?
   6. Is it in favor for us? What's the difference in distance between the existing stores?
 ```
 
## Solution  
  - The Main.java file is the starting point and calls:
  - the form GUI which will be using the Point class (with lombok).
  - In the GUI there are 4 points to be input: 1 origin (homebase) and three other points.
  - In the GUI there are 4 buttons: 
  - Clear, fill with default data, plot chart and calculate.
  - Calculations performed with Calculate.java
  - Can output to system console + Textarea in GUI + plot a chart.
  - Working exceptions with info popup.
  - Implemented Cucumber/Gherkin simple test to test Calculate/Point classes.
  - Simple menu-bar with About window and Exit option with popup checking decision.
  
## Built With
###### App
  - [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
  - Swing UI Designer from IntelliJ + Form builder
  - [XChart](https://github.com/knowm/XChart) - light-weight Java library for plotting data
  - [Project Lombok](https://projectlombok.org/) -  java library that can automatically create setters/getters and so on
###### Tests
  - [Cucumber](https://cucumber.io/) - IntelliJ plugin
  - [Gherkin](https://cucumber.io/docs/gherkin/) - IntelliJ plugin
  
## Screenshots  
  
  ###### Main app window
  ![Window app](https://i.imgur.com/TZ9ud2g.png)
  ###### Chart window
  ![Chart](https://i.imgur.com/Zwiv7dQ.png)
  ###### Cucumber / Gherkin test process within IntelliJ
  ![Test](https://i.imgur.com/uhXxP9p.jpg)
  
  