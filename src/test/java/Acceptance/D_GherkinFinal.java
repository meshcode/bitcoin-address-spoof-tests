package Acceptance;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gherkin.ast.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class D_GherkinFinal {


    //initiate variable for this class to use between methods (ie created in BEFORE and used in AFTER
    //to refer to it and not get a nullpointer error, use "this.myWebDriver"
    private ChromeDriver myWebDriver;
    public WebDriverWait myWaitTimer;

    //
    // TEST SETUP FOR BEFORE AND AFTER (not working for Gherkin. Using "background" notation in feature file for that.
    //

    //BEFORE EACH TEST (NOT FOR STEPS) - OPEN BROWSER WITH URL
    @Before
    public void Setup() throws InterruptedException {
        // Ustawienie ścieżki do ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Uruchom przeglądarke.
        this.myWebDriver = new ChromeDriver();
        //new timer explicit: for each element checks every half second for max 10 seconds
        this.myWaitTimer = new WebDriverWait(this.myWebDriver, 10);
        this.myWebDriver.manage().window().maximize();
        this.myWebDriver.get("http://192.168.56.1:8088");

    }
    //AFTER EACH TEST (NOT FOR STEPS) - CLOSE BROWSER WITH URL
    @After
    public void tearDown() throws InterruptedException {
        //seconds to wait before quitting after all steps complete (so that tester can see action)
        TimeUnit.SECONDS.sleep(1);
        // Wylacz przegladarke.
        this.myWebDriver.quit();
    }


//    @BeforeStep
//    public void myLoadBrowserBeforeStep(){
//        // Ustawienie ścieżki do ChromeDriver
//        WebDriverManager.chromedriver().setup();
//        // Uruchom przeglądarke.
//        this.myWebDriver = new ChromeDriver();
//        //wait for all queries for ten seconds OLD SCHOOL, DO NOT USE
//        //this.myWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        this.myWebDriver.manage().window().maximize();
//        this.myWebDriver.get("http://192.168.56.1:8088");
//    }

    /*

    "GIVEN" STEPS

    */

    @Given("ServerX is Running")
    public void serverXIsRunning() {
        //call the BeforeStep method (above)
        //myLoadBrowserBeforeStep();
        //
        //init the chrome driver setup
        WebDriverManager.chromedriver().setup();
        this.myWebDriver = new ChromeDriver();
        //setup an EXPLICIT wait timer I can call per element/function
        //...for each element checks every half second for max 10 seconds.
        this.myWaitTimer = new WebDriverWait(this.myWebDriver, 10);
        //
        this.myWebDriver.manage().window().maximize();
        this.myWebDriver.get("http://192.168.56.1:8088/");
        //
        this.myWaitTimer.until(ExpectedConditions.urlMatches("http://192.168.56.1:8088/"));
        //
        //display the URL
        String myURLContent = myWebDriver.getCurrentUrl();
        //check that the loaded page has the correct title
        System.out.println("The passed arg is: " + "MKNULL" + " and the webdriver location is: " + "MKNULL" + "URL is: " + myURLContent);
        //
        //ASSERT THE URL
        assertEquals("http://192.168.56.1:8088/", myURLContent);
        //
        //OLD ASSERTIONS
        //Assert.assertEquals(arg0, toString());
    }

    /*

     "WHEN" STEPS

    */

    @When("The Page is Loaded")
    public void thePageIsLoaded() {
        //assert correct title is present
        assertEquals("Public Bitcoin Address Display", this.myWebDriver.getTitle());
        System.out.println("Page Title GOOD: " + this.myWebDriver.getTitle());

       // assertEquals(1,1);
        //check that the loaded page has the correct title
        //Assert.assertEquals("Public Bitcoin Address Display", this.myChromeDriver.getTitle());
    }

    @When("The Header is Loaded")
    public void theHeaderIsLoaded() {
        //uexplicit timer waits for existance of header element (not necessarily visible yet, just testing for presence)
        WebElement myHeaderLoaded = this.myWaitTimer.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        //assert that myHeaderLoaded is loaded, therefore "true" !!-NOTE CAN'T FIND METHOD TO SEE IF IT IS LOADED, OBVIOUSLY IT IS.
        assertTrue(myHeaderLoaded.isDisplayed());
        //write success to console
        System.out.println("The Header is loaded.'");
    }


    @When("I read the Header content")
    public void iReadTheHeaderContent() {
        //explicit timer waits for visibility of element
        WebElement myHeaderLoaded = this.myWaitTimer.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        //I dunno, how do I assert that what I was waiting for actually loaded
        assertTrue(myHeaderLoaded.isDisplayed());
        System.out.println("I read the Header Content and it is: " + myHeaderLoaded.getText());

    }



    /*

     "THEN" STEPS

    */


    @Then("The Header is visible")
    public void theHeaderIsVisible() {
        //explicit timer waits for visibility of element
        WebElement myHeaderLoaded = this.myWaitTimer.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        //I dunno, how do I assert that what I was waiting for actually loaded
        assertTrue(myHeaderLoaded.isDisplayed());
        System.out.println("The header is visible, this is (T/F): " + myHeaderLoaded.isDisplayed());
        //
        //close the automated browser (because I do not know how to make the @After hook work for Gherkin)
        this.myWebDriver.quit();
    }


    @Then("I can see the Bitcoin Address")
    public void iCanSeeTheBitcoinAddress() {

        //Find the CSS Div element which contains the value of the bitcoin address
        WebElement publicBitcoinAddressValue = this.myWebDriver.findElement(By.cssSelector("h1"));
        //check if the bitcoin address is visible (if there is a value inside the element)
        Assert.assertNotNull(publicBitcoinAddressValue);
        //report
        System.out.println("BTC address is visible because it's not NULL. That's all.");

    }

    @Then("The following Bitcoin Address is visible {string}")
    public void theFollowingBitcoinAddressIsVisible(String arg0) {

        //go to the loaded and visible element which contains the bitcoin address
        WebElement bitcoinAddressContainer = this.myWebDriver.findElement(By.xpath("//div[@class='BitcoinAddressDIV']/h1"));
        //retreive the alphanumeric string text from the element. This is the public BTC address.
        String myDisplayedBitcoinAddress = bitcoinAddressContainer.getText();
        //output the address to the console
        System.out.println("The loaded, visible, H1 container has Bitcoin address: " + myDisplayedBitcoinAddress);
        //
        //MAIN SECURITY CHECK: (Observing if MITM ATTAACK ARP/DNS SPOOFING has taken place)
        //compare visible address to the actual database version on tester side
       String myBitcoinAddressVerification = (myDisplayedBitcoinAddress.contains(arg0)) ? "VERIFIED":"SPOOFED";
       //output result to console.
        System.out.println("FINAL: The visible Bitcoin address tested as: " +myBitcoinAddressVerification + ".");
        //Final Assertion
        assertEquals("13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY", bitcoinAddressContainer.getText());
        //
        //close the automated browser (because I do not know how to make the @After hook work for Gherkin)
        this.myWebDriver.quit();
    }




    /*

     STANDALONE TEST

    */

    @Test
    public void testChromeDriverStart() throws InterruptedException {
        //assertEquals(1,1);
        WebElement bitcoinAddressContainer = this.myWebDriver.findElement(By.xpath("//div[@class='BitcoinAddressDIV']/h1[.='13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY']"));
        System.out.println("The H1 container has text: " + bitcoinAddressContainer.getText());
        assertEquals("13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY", bitcoinAddressContainer.getText());
    }

}
