package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepdefinitions.SearchStepDef;

import java.util.Scanner;

import static utils.ReadData.propertyQuery;

public class HomePage {
    WebDriver driver;
    SearchStepDef searchStepDef;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@alt='Google']")
    WebElement googleHeader;
    @FindBy(xpath = "//textarea[@title='Search']")
    WebElement searchInput;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public boolean displayGoogleHeader(){
        return googleHeader.isDisplayed();
    }
    public void enterSearch(){
        searchInput.click();
    }
    public String sendProperty(){
        return propertyQuery.getProperty("query");
    }
    public void sendPropertyQuery(){
        searchInput.sendKeys(sendProperty());
        searchInput.sendKeys(Keys.ENTER);
    }
    public void sendExampleQuery(){
        searchInput.sendKeys(SearchStepDef.qy);
        //searchInput.sendKeys(queries());
        searchInput.sendKeys(Keys.ENTER);
    }

    public void scannerInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Query: ");
        String mi = scan.nextLine();
        System.out.println(mi);
        scan.close();
    }
    public String queries(){
        return "Is 2024 El Nino or La Nina?";
        // How many hurricanes have crossed the Atlantic ocean in 2024?
        // What companies are creating AI hardware?
    }



}
