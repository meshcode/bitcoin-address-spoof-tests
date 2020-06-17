# Bitcoin Address Spoof Tests

[![Build Status](https://travis-ci.org/meshcode/bitcoin-address-spoof-tests.svg?branch=master)](https://travis-ci.org/meshcode/bitcoin-address-spoof-tests)

## Purpose
To create an automated maintenance test for verifying a public bitcoin address in a web application.

This is a basic security test for bitcoin address spoofing. Java HTTP server deploys an HTML webpage with a CSS DIV element containing a bitcoin address. Testing to see if a man-in-the-middle attack may have swapped the address for another.
## Contents
* [Method](#method)
* [Tools](#tools)
* [Screenshots](#screenshots)
* [Report](#report)
* [Issues](#issues)

## Method  
``` 
Display a bitcoin address on web page:
   - Start Java HTTP Server (Main.java) which...
   - serves a basic HTML/CSS webpage which...
   - includes a DIV tag with H1 tag containing a PUBLIC BITCOIN ADDRESS.
   - Check if page serves and loads correctly at local IP
   - Check if page is displaying content (verify)
   - Check if the bitcoin address content is displaying the correct data (validate)

Attack the communication between server and client and spoof bitcoin address:
    - Launch bettercap program on Kali Linux which...
    - turns on ARP spoofing and HTTP proxy script
    - monitor the HTML packet content with live Wireshark analysis

Run automated Selenium Webdriver tests:
    - Test the feature scenarios with high-level languege
    - before the attack: bitcoin address is correct (original)
    - during the attack: bitcoin address is incorrect (spoofed)
    - after the attack: bitcoin address is correct (return to original)
 ```

## Tools

###### App Code and Scripting
  - [IntelliJ](https://www.jetbrains.com/idea/) - IntelliJ IDE for Java projects
  - [Kali Linux](https://www.kali.org/downloads/) - Kali Linux
  - [Visual Studio](https://code.visualstudio.com/) - Visual Studio - hand coded HTML

###### Acceptance and Penetration Tests
  - [Cucumber](https://cucumber.io/) - IntelliJ plugin
  - [Gherkin](https://cucumber.io/docs/gherkin/) - IntelliJ plugin
  - [Chrome Webdriver](https://chromedriver.chromium.org/downloads) - driver for the Chrome browser
  - [Selenium Webdriver](https://www.selenium.dev/documentation/en/) - tools and libraries for browser automation used in IntelliJ projects
  - [TravisCI](https://travis-ci.org/) - Continuous Integration
  - [Bettercap](https://www.bettercap.org/legacy/index.html#proxy-module-module) - Network attacks and monitoring in Kali Linux.
  - [Wireshark](https://www.wireshark.org/) - Packet analyzer
    
## Screenshots  
 
  ##### Browser window with served HTML page (correct BTC address):
  ![App OK](https://i.imgur.com/EUz1tTe.png)
  
  ##### Selenium Webdriver (Cucumber / Gherkin) test process within IntelliJ (correct BTC address):
  ![Test OK](https://i.imgur.com/1Un6JVr.png)
  
  ##### Kali Linux attack with Bettercap perpetrator and Wireshark analyzer:
  ![Attack](https://i.imgur.com/xM58zJB.png)
  
  ##### Main app window (spoofed BTC address):
  ![App NOT OK](https://i.imgur.com/lhbditH.png)
  
  ##### Selenium Webdriver (Cucumber / Gherkin) test process within IntelliJ (spoofed BTC address):
  ![Test NOT OK](https://i.imgur.com/P1EanyS.png)

# Report
## Web Application Security for bitcoin wallet address
Exploiting the psychological vulnerability of trust through an alphanumeric bitcoin wallet address on a webpage. 

#### Context:
Personal financial sovereignty, security and technologies.

#### Delivery Model:
A Windows 10 machine contains a VirtualBox environment with a Kali Linux instance (HACKER) and a Windows 10 instance (VICTIM) using the same NAT (Network Address Translation) network to test the vulnerability of bitcoin wallet address replacement using live ARP (address reolution protocol) spoofing with an HTTP proxy.

#### Collaboration:
Self-Scrumming-Agility. No collaboration, except the sources of wisdom in available technologies, due to complexity of learning everything from scratch.

#### Sources of Risk:
This is a demonstaration of the popular lack of psychological and technological knowledge regarding trust in web application usage.

#### Risk:
The loss of monetary funds of a trusting person wishing to transfer cryptocurrency. A public cryptocurrency wallet address is where one can receive payments. If this is given to a potential client without a verification process then the address itself should not be trusted due to ease of a MITM attack.

Testing strategy:
Simulate victim and client with virtual machines on the same network.

## Preparing for Test Planning

#### See the Process:
Monitoring the plans based on set aims. Prioritizing simplicity due to budget and few days time. Aim is simply to alter a public bitcoin address by means of a brief hack of a webpage.

#### Material on which to design the tests:
The psychology of the lack of understanding of security in popular technologies.

#### Select a testing technique:
A basic MITM attack based on specifications.

#### Type and Level of testing:
Black-box, non-functional, systems-integrations offensive attack testing reliability of visual information. An MITM attack on select transmitted content between a server and client. Replacing HTTP data in packets when it is HTML.

#### Toolkit:
IntelliJ IDE with Maven for the Project Object Model assistance and ease of compiling. Selenium Webdriver is run from within. For the attack, a custom Kali Linux package built on preinstalled modules.

## Planning the Tests

Exploiting the possibility of a bitcoin address spoof in a simple HTML web application. The focus is on networking elements which are known to have vulnerabilities which may affect the desired financial sovereignty product, in this case a public bitcoin wallet address.

Spoofing ARP tables (address resolution protocol) to have victim and router believe they are communicating with eachother when in fact there is a Man-In-The-Middle (Hacker). The victim will see a spoofed bitcoin address on the URL they request. In this way the victim may be psychologically manipulated to send bitcoin to an untrusted wallet unknowingly due to lack of knowledge about trust and security in personal financial sovereignty.

VICTIM COMPUTER is a user who trusts the visible public bitcoin address on the website. 
HACKER COMPUTER on the same network uses ARP SPOOFING to forward a replacement HTML website to the VICTIM by means of an HTTP PROXY script which loads an HTML FILE which looks like the original except the bitcoin address is changed. Note that the URL remains the same as requested by the VICTIM.

#### Environment specifications:
````
Windows 10 with:
- a virtual machine (Virtualbox)
	- Windows 10 with Windows Defender off (Control Panel-->System and Security-->Windows Defender Firewall-->Advanced (turn off Win Def: domain/private/public)
		-Chrome browser
			- Chrome Webdriver exe file for Selenium Webdriver automation (WIN10 START: 'env' go to system variables-->path to set path folder to this exe)
		- OpenJDK from adoptopenjdk.net (add JAVA_HOME variable during install window --> on local disk)
		[Check: java --version, echo %JAVA_HOME%]
		- IntelliJ from jetbrains.com (can automatically update WIN10 Defendeer config to exclude project directories from real-time scanning.)
			- Cucumber and Gherkin plugins
		
	- Kali Linux (penetration testing OS)
		- Apache2 Server with own HTML webpage (EXPECTED AND CORRECT PUBLIC BITCOIN ADDRESS)
		- Bettercap (for WiFi / ethernet MITM attacks)
			- with its own HTML webpage (UNEXPECTED HTML WITH SPOOFED PUBLIC BITCOIN ADDRESS)
		- Wireshark (telecom packet analyzer)
````
#### Test Conditions:
A person wants to send bitcoin to a friends wallet address displayed on their webpage:
Person loads friend's webpage and copies the visible bitcoin address without verifying with the person. They are trusting the website to contain trusted content.

#### Test Case:
````
Title: verifying integrity of public bitcoin wallet address on web page
Version: 1
Category: System Integrations Security
ID: 001SIC
Actor: A trusting victim.
Environment: A Windows 10 machine with a virtualization environment (Virtualbox) with Windows 10 (with Chrome Browser) and Kali Linux (with Bettercap).
Initial Conditions: HTTP server running on Kali machine with correct public bitcoin address HTML web application (index.html). The bettercap program on Kali is listening to connections coming from the victim.
Initial Event: User requests the web application (at URL of the Kali server, its IP).
Data: the server IP is: 10.0.2.15, the correct Bitcoin address is 13Muec......................
Steps:
1) User loads a URL into their browser.
2) A web page is loaded with a visible public bitcoin wallet address.
Expected Result: This is NOT the correct address from the database.
````
#### Automation of Tests:
A Selenium Webdriver test uses Java and Cucumber/Gherkin to test if the bitcoin address has been spoofed. A combination of manual and automated processing is used: The penetration test is done at a certain moment in order to display the changes in test responses while vulnerable compared to exploited.

## Test Execution
The attack for the testing has some preparations (see separate sheet at the meshcode Github repository) but is executed with one line of code:
bettercap -caplet web-override.cap -eval "set arp.spoof.targets 10.0.2.6"

- [Attack Sequence](https://github.com/meshcode/Portfolio-2020/blob/master/3%20-%20Ethical%20Hacking/bitcoin-address-spoof_ATTACK.txt) - Read attack sequence.
- [Attack Video](https://youtu.be/trIAtiGAAqY) - See attack video.

The tests are run with IntelliJ wich uses Java to execute Selenium Webdriver commands which are written in high level Cucumber/Gherkin. Find the repository on the meshcode Github account: bitcoin-address-spoofing. Run the features file, the RunCUcumberTests file or the Acceptance --> Final_Gherkin test.

## After Testing

#### Test Management
The test documentation is organized and cataloged accordingly then published on Github in order to be reproducible.

#### Reports
Security decisions should always clearly be made regarding computers allowed on same network as the server. Mitigation or reduction of risk can be made by frequent automated testing in order to verify and validate critical information such as a public bitcoin wallet address. Try using HTTPS or other means of a more secure presentation of a public bitcoin address. One method of prevention is XARP, a tool designed to warn about manipulations in IP/MAC mappings.

The RunCucumberTest class in the test/java folder creates an html page with a technical report which can be viewed by loading the project /target/cucumber/index.html file from within the browser.
#### Management of Defects
This project is part of a junior collection of vulnerabilities which serve as a management hub to return to for future testing.

# Issues
#### Questions
````
- what is the relationship of Selenium Webdriver to Gherkin at runtime?
- why doesn't this pass the build on Travic CI?
- why doesn't @before work for steps?
- why does my feature file only read the Gherkin_Final acceptance class?
````
#### Notes
````
- the step has to do the work. Assert checks if it is complete.
- Run Main.class to start the server. Test with Gherkin_Final, feature file, RunCucumberTest.
````








