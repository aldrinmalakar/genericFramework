package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LoginPage;

import static pageElements.LoginPageElements.*;

public class loginPageSteps {

    WebDriver driver;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    /* //Setting up the pageFactory
     LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
 */
    @Given("user is on the WebReads UAT Login page")
    public void user_is_on_the_WebReads_UAT_Login_page() {
        DriverFactory.getDriver().get(webReadsURL);
    }

    @Given("the library id is set to {string}")
    public void the_library_id_is_set_to(String libraryID) {
        Select libraryDropDown = new Select(loginPage.libraryIDDropDown);

        if (libraryID.equalsIgnoreCase("RJ1A - NLS")) {
            //Perform a code
            libraryDropDown.selectByValue(libraryValueRJ1A);
        } else if (libraryID.equalsIgnoreCase("LC*3 - NLS Overseas")) {
            //Perform a code
            libraryDropDown.selectByValue(getLibraryValueLC3);
        } else {
            System.out.println("Please Select a Value between 'RJ1A - NLS' Or 'LC*3 - NLS Overseas' ");
        }

    }

    @When("user enters valid userName {string}")
    public void userEntersValidUserName(String userName) {
        loginPage.enterUserName(userName);
    }

    @And("user enters valid password {string}")
    public void userEntersValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks {string} button")
    public void userClicksButton(String clickableButton) {
        if (clickableButton.equalsIgnoreCase("Log In")) {
            loginPage.clickLoginButton();
        } else if (clickableButton.equalsIgnoreCase("Agree")) {
            loginPage.clickAgreeButton();
        } else {
            System.out.println("Specified Buttons Were Not Found. Please Update Code For Clickable Button.");
        }
    }

    @Then("user gets redirected to {string}")
    public void userGetsRedirectedTo(String expectedURL) {
        Assert.assertTrue(loginPage.getCurrentURL().equalsIgnoreCase(patronAccountURL));
    }

    @Then("user verifies the title of the page is {string}")
    public void userVerifiesTitle(String expectedTitle) {
        Assert.assertEquals(loginPage.getPageTitle(), expectedTitle, "Test Failed: Actual Title Does Not Match The Expected");
    }


}
