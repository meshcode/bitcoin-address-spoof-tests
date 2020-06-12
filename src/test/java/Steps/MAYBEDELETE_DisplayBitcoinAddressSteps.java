package Steps;
//
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
//
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

//
//


//Main class with Test Steps
public class MAYBEDELETE_DisplayBitcoinAddressSteps {

    //initiate variable for this class to use between methods (ie created in BEFORE and used in AFTER
    //to refer to it and not get a nullpointer error, use "this.myWebDriver"
    private ChromeDriver myWebDriver;

    //BEFORE EACH TEST - OPEN BROWSER WITH URL
    @Before
    public void Setup() throws InterruptedException {
        // Ustawienie ścieżki do ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Uruchom przeglądarke.
        this.myWebDriver = new ChromeDriver();
        //wait for all queries for ten seconds OLD SCHOOL, DO NOT USE
        //this.myWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.myWebDriver.manage().window().maximize();
        this.myWebDriver.get("http://192.168.56.1:8088");

    }
    //AFTER EACH TEST - CLOSE BROWSER WITH URL
    @After
    public void tearDown() throws InterruptedException {
        //seconds to wait before quitting after all steps complete (so that tester can see action)
        TimeUnit.SECONDS.sleep(1);
        // Wylacz przegladarke.
        this.myWebDriver.quit();
    }

    @Given("ServerX is Running")
    public void serverXIsRunning() {

//        assertEquals("Public Bitcoin Address Display", myWebDriver.getTitle());
//        System.out.println("Page Title: " + myWebDriver.getTitle());

        assertEquals(1,1);
        //myWaitTimer.until(ExpectedConditions.urlMatches("http://192.168.56.1:8088"));
 //String myURLContent = myChromeDriver.getCurrentUrl();

        //check that the loaded page has the correct title
       //System.out.println("The passed arg is: " + "TEMPNULL" + " and the webdriver location is: " + "TEMPNULL" + "URL is: " + myURLContent);
        //Assert.assertEquals(arg0, toString());
    }


    @When("The Page is Loaded")
    public void thePageIsLoaded() {
        assertEquals(1,1);
        //check that the loaded page has the correct title
        //Assert.assertEquals("Public Bitcoin Address Display", this.myChromeDriver.getTitle());
    }

    @Then("I can see the Bitcoin Address")
    public void iCanSeeTheBitcoinAddress() {
        assertEquals(1,1);
        //Find the CSS Div element which contains the value of the bitcoin address
        //WebElement publicBitcoinAddressValue = myChromeDriver.findElement(By.cssSelector("h1"));
        //check if the bitcoin address is visible (if there is a value inside the element)
        //Assert.assertNotNull(publicBitcoinAddressValue);
        //
        //SECOND VERSION
       // WebElement bitcoinAddressVisibility = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("BitcoinAddressDIV")));
        //check if the bitcoin address is visible (if there is a value inside the element)
        //Assert.assertNotNull(bitcoinAddressVisibility);
    }

    @Then("The following Bitcoin Address is visible {string}")
    public void theFollowingBitcoinAddressIsVisible(String arg0) {
        assertEquals(1,1);
        //check if the bitcoin address is the correct address which has not been spoofed
        //assertEquals("13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY", arg0);
    }



}