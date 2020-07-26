package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TicketDetails {

    WebDriver driver = null;


    public TicketDetails(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement addCommentButton = $(By.id("footer-comment-button"));
    private WebElement textModeButton = $(By.xpath("//div[@id='comment-wiki-edit']//a[contains (text(), 'Text')]"));
    private WebElement newCommentField = $(By.id("comment"));
    private WebElement saveCommentButton = $(By.id("issue-comment-add-submit"));
    private WebElement deleteCommentIcon = $(By.xpath("//span[@class='icon-default aui-icon aui-icon-small aui-iconfont-delete']"));
    private WebElement confirmDeletingCommentButton = $(By.id("comment-delete-submit"));


    public void checkIsTicketNameIsPresent(){
        $(By.xpath("//a[@class='issue-link' and @data-issue-key='WEBINAR-11939']")).shouldBe(Condition.visible);
    }

    public void clickOnTheAddCommentButton(){
        $(addCommentButton).click();
    }

    public void waitingForSaveCommentButton(){
        $(By.xpath("//div[@id='comment-wiki-edit']//a[contains (text(), 'Text')]")).shouldBe(Condition.visible);
    }

    public void goToTextModeForAddingComment(){
        $(textModeButton).click();
    }

    public void typeNewCommentToTheCommentField(String comment){
        $(newCommentField).sendKeys(comment);
    }

    public void isSaveButtonIsActive(){
        $(By.id("issue-comment-add-submit")).shouldBe(Condition.enabled);
    }

    public void clickOnTheSaveCommentButton(){
        $(saveCommentButton).click();
    }

    public void checkIfNewCommentAppeared(){
        $(By.id("issue-comment-add-submit")).shouldBe(Condition.enabled);
    }

    public void waitingWhenAddNewCommentFieldWillBeClosed(){
        $(By.id("footer-comment-button")).shouldBe(Condition.enabled);
    }

    public void checkIfTestCommentAppeared(){
        $(By.xpath("//div[@class='action-body flooded']//p[contains(text(), 'My random comment')]")).shouldBe(Condition.visible);
    }

    public void clickOnTheDeleteCommentIcon(){
        $(deleteCommentIcon).click();
    }

    public void isDeleteConfirmationPopUpIsOpen(){
        $(By.xpath("//h2['Delete Comment']")).shouldBe(Condition.visible);
    }

    public void confirmCommentDelete(){
        $(confirmDeletingCommentButton).click();
    }

    public void checkSuccessDeleteMessage(){
        $(By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']")).shouldBe(Condition.visible);
    }

    public void checkIfCommentIsNotExists(){
        $(By.xpath("//div[@class='action-body flooded']//p[contains(text(), 'My random comment')]")).shouldNotBe(Condition.visible);
    }

}
