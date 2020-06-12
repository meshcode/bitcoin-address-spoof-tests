package Acceptance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class A_OpenCloseBrowserWindow {
    @Test
    public void testChromeDriverStart() throws InterruptedException {
        // Ustawienie ścieżki do ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Uruchom przeglądarke.
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://192.168.56.1:8088");
        TimeUnit.SECONDS.sleep(2);
        // Wylacz przegladarke.
        webDriver.quit();
    }
}
