package pl.dan.qagui.classic.modules;

import pl.dan.qagui.classic.Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Comment extends BasePage {

    public Comment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".button.form-button is-primary")
    public WebElement saveSettingsButton;

    @FindBy(css = ".notification-settings-form-stream:nth-child(2) ul li:nth-child(1) input")
    public WebElement likeRingCheckbox;
}
