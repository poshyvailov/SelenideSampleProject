package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class JiraMainPage {

    WebDriver driver = null;

    public JiraMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement createButton = $(By.id("create_link"));
    private WebElement searchTicketField = $(By.id("quickSearchInput"));



    public void checkIfMainPageIsOpen(){
        $(By.xpath("//*[@id='dashboard-content']//h1")).shouldBe(Condition.visible);
    }

    public void waitUntilOpenListOfAssignedTickets(){
        $(By.xpath("//*[@class='date-header' and contains(text(), 'Today')]")).shouldBe(Condition.visible);
    }

    public void isCreateTicketButtonIsActive(){
        $(createButton).shouldBe(Condition.enabled);
    }

    public void checkIfJiraMainPageIsFullyOpened(){
        $(By.id("browse_link")).shouldBe(Condition.enabled);
    }

    public void clickOnTheCreateButton(){
        $(createButton).click();
    }

    public void checkIfCreateTicketWindowIsOpen(){
        $(By.xpath("//h2[@title='Create Issue']")).shouldBe(Condition.visible);
    }

    public void waitingWhenSearchFieldWillAppear(){
        $(searchTicketField).shouldBe(Condition.visible);
    }

    public void typeTicketNameToSearch(String ticketName){
        $(searchTicketField).sendKeys(ticketName);
    }

    public void pressEnterForSearchField(){
        $(searchTicketField).sendKeys(Keys.ENTER);
    }


}
