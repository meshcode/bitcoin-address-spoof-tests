package Acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class C_BeforeGherkinAfter {

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


    @Test
    public void testChromeDriverStart() throws InterruptedException {
        //assertEquals(1,1);
        WebElement bitcoinAddressContainer = this.myWebDriver.findElement(By.xpath("//div[@class='BitcoinAddressDIV']/h1[.='13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY']"));
        System.out.println("The H1 container has text: " + bitcoinAddressContainer.getText());
        assertEquals("13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY", bitcoinAddressContainer.getText());
    }


}
