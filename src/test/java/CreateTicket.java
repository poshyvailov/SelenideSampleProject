import Pages.CreateTicketWindow;
import Pages.JiraMainPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

public class CreateTicket {

    LoginPage loginPage;
    JiraMainPage jiraMainPage;
    CreateTicketWindow createTicketWindow;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = browserName;
        open();
        loginPage = new LoginPage(getWebDriver());
        jiraMainPage = new JiraMainPage(getWebDriver());
        createTicketWindow = new CreateTicketWindow(getWebDriver());
    }

    @Test
    public void createTicketPositiveTest(){
        loginPage.openTestPage();
        loginPage.enterUserName("poshyvailov");
        loginPage.enterUserPassword("poshyvailov");
        loginPage.clickLoginButton();
        jiraMainPage.checkIfMainPageIsOpen();
        jiraMainPage.checkIfJiraMainPageIsFullyOpened();

        //Находим и нажимаем на кнопку Create
        jiraMainPage.clickOnTheCreateButton();
        jiraMainPage.checkIfCreateTicketWindowIsOpen();

        //Ищем поле Project, чистим его, вводим наши данные, нажимаем табуляцию
        createTicketWindow.clearTicketProjectField();
        createTicketWindow.ticketTypeProjectName("Webinar (WEBINAR)");
        createTicketWindow.ticketProjectFieldClickTabButton();
        createTicketWindow.ticketWaitingForDescriptionWillBeActive();

        //Ищем поле Issue Type, чистим его, вводим наши данные, нажимаем табуляцию
        createTicketWindow.ticketClearIssueTypeField();
        createTicketWindow.ticketSelectIssueType("Task");
        createTicketWindow.ticketIssueTypeFiledPresTabButton();
        createTicketWindow.ticketWaitingForDescriptionWillBeActive();

        //Заполняем поле с саммари
        createTicketWindow.ticketTypeSummary("Some New Ticket For Test");
        createTicketWindow.ticketSummaryFieldPressTabButton();

        //Нажимаем на кнопку для создания тикета, проверяем,что появился поп-ап с сообщением о создании ти кета
        createTicketWindow.ticketCLickSaveTicketButton();
        createTicketWindow.checkIfSuccessPopUpIsPresent();

        //Проверяем что в поп апе есть названия проекта,в который был создан тикет ("WEBINAR")
        createTicketWindow.checkIfPopUpContainsWebinarName();
        createTicketWindow.checkIfPopUpContainsWebinarName();

    }

}
