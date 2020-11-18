package pl.dan.qagui;

import Page.ConfigFrontEnd;
import Page.MainWordpressPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pl.dan.qa.gui.config.GuiConfig;

@Tags({@Tag("frontend"),@Tag("ActionTest")})
public class ActionTest extends ConfigFrontEnd {


    @DisplayName("Simple action")
    @Test
    public void actionTest() {
        driver.navigate().to(GuiConfig.BASE_URL);

        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        Actions action = new Actions(driver);

        action.moveToElement(mainWordpressPage.picture)
                .clickAndHold()
                .moveToElement(mainWordpressPage.startYourWebsite)
                .release();
        action.build().perform();

//        action.moveToElement(mainWordpressPage.loginButton)
//                .click();
//        action.build().perform();
    }

    @DisplayName("Keys short")
    @Test
    public void kaysInteraction() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.CONTROL, "R")).perform();
        action.sendKeys(Keys.chord(Keys.ESCAPE)).perform();
        action.sendKeys(Keys.chord(Keys.ENTER)).perform();


    }

}
