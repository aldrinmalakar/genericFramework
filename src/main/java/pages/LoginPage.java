package pages;

import org.openqa.selenium.WebDriver;

//Importing elements from pageElements class
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static pageElements.LoginPageElements.*;

public class LoginPage {


    private WebDriver driver;
    //1. Using @FindBy Locators
    @FindBy(how = How.ID, using = libraryIDDropDownID)
    public WebElement libraryIDDropDown;
    @FindBy(how = How.ID, using = patronIDID)
    public WebElement patronIDBox;
    @FindBy(how = How.ID, using = passwordID)
    public WebElement passwordBox;
    @FindBy(how = How.ID, using = loginButtonID)
    public WebElement loginButton;
    @FindBy(how = How.XPATH,using = agreeButtonXpath)
    public WebElement agreeButton;


    //2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page actions: These are the methods that will define the actions inside steps
    public void getToLoginPage(String pageURL) {
        driver.get(webReadsURL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterUserName(String userName) {
        patronIDBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void clickAgreeButton(){
    agreeButton.click();
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

}
