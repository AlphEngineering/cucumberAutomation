package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.BrowserFactory;

public class BaseTest {
    WebDriver driver = null;
    HomePage homePage;


    public void setup(){
        driver = BrowserFactory.launchBrowser("browser");
        driver.get("https://demo.midtrans.com/");
        homePage = new HomePage(driver);
    }


    public void quit(){
        driver.close();
    }

}


