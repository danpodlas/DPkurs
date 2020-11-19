package cucumber.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.dan.qa.gui.config.GuiConfig;
import pl.dan.qagui.classic.Page.LoginPage;
import pl.dan.qagui.classic.Page.MainWordpressPage;

public class LoginFunction {

    private WebDriver driver;

    public LoginFunction(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
        mainWordpressPage.loginButton.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput.clear();
        loginPage.loginInput.click();
        loginPage.loginInput.sendKeys(GuiConfig.LOGIN);
        loginPage.logginButton.click();

        loginPage.waitForVisibilityOfElement(By.id(LoginPage.password), 15);

        loginPage.passwordInput.clear();
        loginPage.passwordInput.click();
        loginPage.passwordInput.sendKeys(GuiConfig.PASSWORD);
        loginPage.passwordButton.click();

    }
}
