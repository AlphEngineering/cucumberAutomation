package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.*;
import utils.BrowserFactory;
import utils.GenericMethods;

import java.util.Scanner;

import static utils.ReadData.*;

public class SearchStepDef {
    WebDriver driver = null;
    HomePage homePage;
    Scanner scan = null;

    @Before
    public void setup(){
        driver = BrowserFactory.launchBrowser("browser");
        homePage = new HomePage(driver);
        GenericMethods.pauseExecutionFor(5);
    }
    @Given("{string} is loaded")
    public void search_engine_is_loaded(String search_engine){
        driver.get(search_engine = propertyConfig.getProperty("search_engine"));
        Assert.assertTrue(homePage.displayGoogleHeader());
        System.out.println(homePage.getCurrentUrl());
    }
    @When("{string} is entered")
    public void query_is_entered_property(String query){
        homePage.enterSearch();
        scan.next(query = propertyQuery.getProperty("query"));
    }
    @When("{string} is entered")
    public void query_is_entered_examples(String query){
        System.out.println(query);

        String A = "Is 2024 El Nino or La Nina?";
        String B ="How many hurricanes have crossed the Atlantic ocean in 2024";
        String C = "What companies are creating AI hardware?";
    }
    @Then("site returns results")
    public void site_returns_results(){
    }

    //@After
    public void quit(){
        driver.close();
    }

}


