package pl.dan.qagui;

import Page.ConfigFrontEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Tags({@Tag("Frontend"), @Tag("Window")})
public class WindowsTest extends ConfigFrontEnd {


    @DisplayName("Window test")
    @Test
    public void windowTest() {

        String firstPageWindow;
        String secondWindow;

        String urlDiary = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.navigate().to(urlDiary);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in the same window")));

        firstPageWindow = driver.getWindowHandle();

    }
}
