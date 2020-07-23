package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

    WebDriver driver = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement userNameField = $(By.id("login-form-username"));
    private WebElement loginField = $(By.id("login-form-password"));
    private WebElement loginButton = $(By.id("login"));


    public void openTestPage() {
        open("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public void waitUntilLoginPageWillBeOpen(){
        $(userNameField).shouldBe(Condition.visible);
    }

    public void enterUserName(String name) {
        $(userNameField).setValue(name);
    }

    public void enterUserPassword(String password) {
        $(loginField).setValue(password);
    }

    public void clickLoginButton() {
        $(loginButton).click();
    }

    public void waitUntilDashboardWillBeOpen() {
        $(By.xpath("//*[@id='dashboard-content']//h1")).shouldBe(Condition.visible);
    }

    public void isErrorsMessageIsShown(String errorMessage) {
        $(By.xpath("//*[contains(text(),'\" + errorMessage + \"')]")).shouldBe(Condition.visible);
    }


}
