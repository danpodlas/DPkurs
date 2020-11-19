package pl.dan.qagui.classic;

import pl.dan.qagui.classic.Page.MainUserPage;
import pl.dan.qagui.classic.Page.NotificationUserPage;
import pl.dan.qagui.classic.Page.UserProfilePage;
import pl.dan.qagui.classic.functional.LoginFunction;
import pl.dan.qagui.classic.modules.CommentModule;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pl.dan.qa.gui.config.GuiConfig;


import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("frontend")
@DisplayName("Frontend test")
public class FrontendTest extends ConfigFrontEnd {



    @DisplayName("Login test")
    @Test
    public void loginTest() {
        driver.get("https://wordpress.com/");
        driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("daniel9332@o2.pl");
        driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("podlas693");
        driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();

        String welcomeText = driver.findElement(By.className("empty-content__title")).getText();

        assertThat(welcomeText).isEqualTo("Witaj w Czytniku");

    }

    @DisplayName("Check user")
    @Test
    public void checkUser() {
        driver.get("https://wordpress.com/");

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();

        MainUserPage mainUserPage = new MainUserPage(driver);
        mainUserPage.userAvatar.click();

        UserProfilePage userProfilePage = new UserProfilePage(driver);
        String userName = userProfilePage.userNamePanel.getText();

        assertThat(userName).isEqualTo("danpodlas");

    }

    @DisplayName("Check save button on user profile cucumber.page.")
    @Test
    public void saveButton() {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();

        MainUserPage mainUserPage = new MainUserPage(driver);
        mainUserPage.userAvatar.click();

        UserProfilePage userProfilePage = new UserProfilePage(driver);

        assertTrue(userProfilePage.saveButton.isDisplayed());
        assertFalse(userProfilePage.saveButton.isEnabled());

    }

    @RepeatedTest(10)
    @DisplayName("Check selected element.")
    @Test
    public void selectedElement() throws InterruptedException {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();

        MainUserPage mainUserPage = new MainUserPage(driver);

        mainUserPage.waitForElementToBeClickable(mainUserPage.userAvatar);
        mainUserPage.userAvatar.click();

        UserProfilePage userProfilePage = new UserProfilePage(driver);

        int j = 0;
        boolean displayed = false;
        while (!displayed) {
            System.out.println("++++++++++" + j++);
            try {
                userProfilePage.notificationLabel.click();
                displayed = true;
            } catch (Exception e) {
                displayed = false;
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                mainUserPage.userAvatar.click();
            }
        }

        NotificationUserPage notificationUserPage = new NotificationUserPage(driver);
        notificationUserPage.getCommentsLabel().click();

        CommentModule commentModule = notificationUserPage.getCommentModule();

//        assertTrue(commentModule.likeRingCheckbox.isSelected());
//        commentModule.waitForElementToBeClickable(commentModule.likeRingCheckbox, 10);
//        commentModule.likeRingCheckbox.click();
//        commentModule.waitForElementToBeUnSelected(commentModule.likeRingCheckbox);
//        assertFalse(commentModule.likeRingCheckbox.isSelected());
//        commentModule.waitForElementToBeClickable(commentModule.likeRingCheckbox, 10);
//        commentModule.likeRingCheckbox.click();
//        assertTrue(commentModule.likeRingCheckbox.isSelected());

        int counter = 0;
        boolean selected = false;
        while (!selected & counter < 20) {
            sleep(500);
            if (commentModule.likeRingCheckbox.isSelected()) {
                selected = true;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        assertTrue(commentModule.likeRingCheckbox.isSelected());
        commentModule.likeRingCheckbox.click();

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        counter = 0;
        boolean selected2 = true;
        while (selected2 & counter < 20) {
            sleep(500);
            if (!commentModule.likeRingCheckbox.isSelected()) {
                selected2 = false;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        commentModule.saveSettingsButton.click();

        assertFalse(commentModule.likeRingCheckbox.isSelected());

        commentModule.likeRingCheckbox.click();

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        counter = 0;
        boolean selected3 = false;
        while (!selected3 & counter < 20) {
            sleep(500);
            if (commentModule.likeRingCheckbox.isSelected()) {
                selected3 = true;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        assertTrue(commentModule.likeRingCheckbox.isSelected());

    }


}
