package Steps;
//
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.*;
//
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
//
import java.util.concurrent.TimeUnit;

//Main class with Test Steps
public class DisplayBitcoinAddressSteps {

    /*
    HOOKS FOR BEFORE AND AFTER the Steps are ran
    */

    public ChromeDriver webDriver;
    public WebDriverWait wait;

    //BEFORE EACH TEST - OPEN BROWSER WITH URL
    @Before
    public void Setup() {
        //?
        BasicConfigurator.configure();
        // ChromeDriver path setup
        WebDriverManager.chromedriver().setup();
        // Start Driver for Chrome
        this.webDriver = new ChromeDriver();
        // set Chrome browser max window size
        this.webDriver.manage().window().maximize();

        // Implicit wait - LESS USED
        //this.webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //
        // Explicit wait - tries every 500ms for 10 sec
        this.wait = new WebDriverWait(this.webDriver, 10);
        //
        //the site location is my own local IPv4 (find with CMD ipconfig) and port 8088 in my code below
        this.webDriver.get("http://192.168.56.1:8088/");
    }

    //AFTER EACH TEST - CLOSE BROWSER WITH URL
    @After
    public void tearDown() throws InterruptedException {
        //wait three seconds after steps are complete
        TimeUnit.SECONDS.sleep(3);
        // Quit the browser with the webdriver
        this.webDriver.quit();
    }

    @Given("Server is Running at {string}")
    public void serverIsRunning(String arg0) {
        //check that the loaded page has the correct title
        System.out.println("The passed arg is: " + arg0 + " and the webdriver location is: " + this.webDriver.location());
        //Assert.assertEquals(arg0, toString());
    }


    @When("The Page is Loaded")
    public void thePageIsLoaded() {
        //check that the loaded page has the correct title
        //Assert.assertEquals("Public Bitcoin Address Display", this.webDriver.getTitle());
    }

    @Then("I can see the Bitcoin Address")
    public void iCanSeeTheBitcoinAddress() {
        //Find the CSS Div element which contains the value of the bitcoin address
        WebElement publicBitcoinAddressValue = webDriver.findElement(By.className("BitcoinAddressDIV"));
        //check if the bitcoin address is visible (if there is a value inside the element)
        Assert.assertNotNull(publicBitcoinAddressValue);
        //
        //SECOND VERSION
        WebElement bitcoinAddressVisibility = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("BitcoinAddressDIV")));
        //check if the bitcoin address is visible (if there is a value inside the element)
        Assert.assertNotNull(bitcoinAddressVisibility);
    }

    @Then("The following Bitcoin Address is visible {string}")
    public void theFollowingBitcoinAddressIsVisible(String arg0) {
        //check if the bitcoin address is the correct address which has not been spoofed
        assertEquals("13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY", arg0);
    }


}