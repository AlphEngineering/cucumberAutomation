package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    String search_engine;
    Scanner scan = new Scanner(System.in);

    @Before
    public void start_up(){
        driver = BrowserFactory.launchBrowser("browser");
        driver.get(search_engine = propertyConfig.getProperty("search_engine"));
        homePage = new HomePage(driver);
        GenericMethods.pauseExecutionFor(5);
    }
    @Given("search engine is loaded")
    public void search_engine_is_loaded(){
        Assert.assertTrue(homePage.displayGoogleHeader());
        System.out.println(homePage.getCurrentUrl());
    }
    @When("a {string} is entered using properties")
    public void query_is_entered_using_property(String query){
        homePage.enterSearch();
        String qy = query;
        qy = scan.next(propertyQuery.getProperty("query"));
    }

    @When("a {string} is entered using examples")
    public void query_is_entered_using_examples(String query){
        String q = query;
        System.out.println(q);
        homePage.enterSearch();
        q = scan.nextLine();

        String A = "Is 2024 El Nino or La Nina?";
        String B ="How many hurricanes have crossed the Atlantic ocean in 2024";
        String C = "What companies are creating AI hardware?";
    }
    @Then("site returns results")
    public void site_returns_results(){
        System.out.println(driver.getTitle());
    }

    //@After
    public void shut_down(){
        driver.close();
    }

}


