package org.crossbrowsertesting.web;

import org.crossbrowsertesting.utils.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class URLVerification {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){}
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions co=new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
    @Test
    public void URLverification(){
        try{
            driver.get(StaticString.url);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            Thread.sleep(5000);
            GetScreenshot.screenshot(driver);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        //Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterClass
    public void afterClass(){}
}
