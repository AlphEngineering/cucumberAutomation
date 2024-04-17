package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.BrowserFactory;

import java.util.Scanner;

public class BaseTest {
    WebDriver driver = null;
    HomePage homePage;


//    public void setup(){
//        driver = BrowserFactory.launchBrowser("browser");
//        driver.get("https://demo.midtrans.com/");
//        homePage = new HomePage(driver);
//    }
    @Test
    public void manual_input_test() {
        System.out.println("Query using Manual Input");
        //homePage.enterSearch();
        Scanner sc = new Scanner(System.in);
        String mi = sc.nextLine();
        System.out.println(mi);
        //scan.nextLine();
        //String mi = scan.nextLine();
        sc.close();
    }


//    public void quit(){
//        driver.close();
//    }

}


