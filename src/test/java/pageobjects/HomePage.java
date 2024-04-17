package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
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


}
