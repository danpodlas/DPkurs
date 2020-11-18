package Page;

import modules.CommentModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationUserPage extends BasePage{

    private CommentModule commentModule;

    public NotificationUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/me/notifications/comments\"]")
    private WebElement commentsLabel;

    public WebElement getCommentsLabel() {
        if (commentModule == null) {
            commentModule = new CommentModule(driver);
        }
        return commentsLabel;
    }

    public CommentModule getCommentModule() {
        return commentModule;
    }

}
