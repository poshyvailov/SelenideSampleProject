package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.codeborne.selenide.Config;

import java.security.Key;

import static com.codeborne.selenide.Selenide.$;

public class CreateTicketWindow {

    WebDriver driver = null;

    public CreateTicketWindow(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement ticketProjectField = $(By.id("project-field"));
    private WebElement ticketIssueTypeField = $(By.id("issuetype-field"));
    private WebElement ticketSummaryField = $(By.id("summary"));
    private WebElement saveTicketButton = $(By.id("create-issue-submit"));


    public void clearTicketProjectField() {
        $(ticketProjectField).clear();
    }

    public void ticketTypeProjectName(String projectName) {
        $(ticketProjectField).sendKeys(projectName);
    }

    public void ticketProjectFieldClickTabButton() {
        $(ticketProjectField).sendKeys(Keys.TAB);
    }

    public void ticketClearIssueTypeField() {
        $(ticketIssueTypeField).clear();
    }

    public void ticketSelectIssueType(String issueTypeName) {
        $(ticketIssueTypeField).sendKeys(issueTypeName);
    }

    public void ticketIssueTypeFiledPresTabButton() {
        $(ticketIssueTypeField).sendKeys(Keys.TAB);
    }

    public void ticketWaitingForDescriptionWillBeActive() {
        $(By.id("description")).shouldBe(Condition.visible);
    }

    public void ticketTypeSummary(String summary) {
        $(ticketSummaryField).sendKeys(summary);
    }

    public void ticketSummaryFieldPressTabButton(){
        $(ticketSummaryField).sendKeys(Keys.TAB);
    }

    public void ticketCLickSaveTicketButton() {
        $(saveTicketButton).click();
    }

    public void checkIfSuccessPopUpIsPresent() {
        $(By.id("aui-flag-container")).shouldBe(Condition.visible);
    }

    public void checkIfPopUpContainsWebinarName() {
        $(By.xpath("//*[@id='aui-flag-container']//a[contains (text(), 'WEBINAR')]")).shouldBe(Condition.visible);
    }


}
