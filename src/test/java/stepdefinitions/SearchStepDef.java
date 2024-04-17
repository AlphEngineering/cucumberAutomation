package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.*;
import utils.BrowserFactory;
import utils.GenericMethods;

import java.time.Duration;
import java.util.Scanner;

import static utils.ReadData.*;

public class SearchStepDef {
    WebDriver driver;
    HomePage homePage;
    String search_engine;
    public static String qy;
    Scanner scan = new Scanner(System.in);
    @FindBy(xpath = "//textarea[@title='Search']")
    WebElement searchInput;
    @Before
    public void start_up(){
        driver = BrowserFactory.launchBrowser("browser");
        driver.get(search_engine = propertyConfig.getProperty("search_engine"));
        homePage = new HomePage(driver);
        GenericMethods.pauseExecutionFor(5);
    }
    @Given("Search engine is loaded")
    public void search_engine_is_loaded(){
        Assert.assertTrue(homePage.displayGoogleHeader());
        System.out.println("Search Engine: "+homePage.getCurrentUrl());
    }
    @When("{string} is entered using properties")
    public void query_is_entered_using_property(String Query){
        System.out.println("Query using Property");
        homePage.enterSearch();
        homePage.sendPropertyQuery(); //Uses query.properties to send queries
    }

    @When("{string} is entered using examples")
    public void query_is_entered_using_examples(String Query){
        System.out.println("Query using Example");
        homePage.enterSearch();
        qy = Query; //Sends queries from Scenario Outline Examples using static variable 'qy'
        homePage.sendExampleQuery();
        //homePage.queries(); //Sends queries from method on HomPage
    }
    @When("{string} is entered using manual input")
    public void query_is_entered_using_manual_input(String Query) {
        System.out.println("Query using Manual Input");
        homePage.enterSearch();
        homePage.scannerInput(); //Console is view only.  Unable to input via Scanner
//        System.out.print("Query: ");
//        String mi = scan.nextLine();
//        System.out.println(mi);
//        scan.close();

    }
    @Then("Site returns results")
    public void site_returns_results(){
        System.out.println(driver.getTitle());
        System.out.println();
    }

    @After
    public void shut_down(){
        driver.close();
    }

}


