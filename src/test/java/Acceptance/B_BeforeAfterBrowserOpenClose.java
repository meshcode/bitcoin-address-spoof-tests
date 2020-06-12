package Acceptance;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class B_BeforeAfterBrowserOpenClose {
    //initiate variable for this class to use between methods (ie created in BEFORE and used in AFTER
    //to refer to it and not get a nullpointer error, use "this"
    private ChromeDriver myWebDriver;

    //BEFORE EACH TEST - OPEN BROWSER WITH URL
    @Before
    public void Setup() throws InterruptedException {
        // Ustawienie ścieżki do ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Uruchom przeglądarke.
        this.myWebDriver = new ChromeDriver();
        this.myWebDriver.manage().window().maximize();
        this.myWebDriver.get("http://192.168.56.1:8088");

    }
    //AFTER EACH TEST - CLOSE BROWSER WITH URL
    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
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
