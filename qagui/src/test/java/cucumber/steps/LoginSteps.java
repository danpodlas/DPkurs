package cucumber.steps;


import cucumber.ConfigBaseStep;
import cucumber.functional.LoginFunction;
import cucumber.page.MainUserPage;
import cucumber.page.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pl.dan.qa.gui.config.GuiConfig;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(ConfigBaseStep configBaseStep) {
        this.driver = configBaseStep.setUpWebDriver();
    }

    @Given("User starts on main page")
    public void userStartsOnMainPage() {
        driver.navigate().to(GuiConfig.BASE_URL);
    }

    @When("User logs to the user panel")
    public void userLogsToTheUserPanel() {
        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();
    }

    MainUserPage mainUserPage;
    @Then("User can modify user profile")
    public void userCanModifyUserProfile() {
        mainUserPage = new MainUserPage(driver);
        String welcomeText = mainUserPage.welcomeText.getText();
        assertThat(welcomeText).isEqualTo("Witaj w Czytniku");
    }

    @And("User checks search button")
    public void userChecksSearchButton() {
        mainUserPage = new MainUserPage(driver);
        assertTrue(mainUserPage.searchButton.isDisplayed());
    }

    @When("User clicks to search button")
    public void userClicksToSearchButton() {
        mainUserPage.searchButton.click();
    }

    @Then("User arrives to search panel")
    public void userArrivesToSearchPanel() {
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.searchInput.isDisplayed());
    }
}

