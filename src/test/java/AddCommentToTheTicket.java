import Pages.JiraMainPage;
import Pages.LoginPage;
import Pages.TicketDetails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.isOpera;
import static org.testng.AssertJUnit.assertTrue;

public class AddCommentToTheTicket {

    LoginPage loginPage;
    JiraMainPage jiraMainPage;
    TicketDetails ticketDetails;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        open();
        Configuration.browser = browserName;
        loginPage = new LoginPage(getWebDriver());
        jiraMainPage = new JiraMainPage(getWebDriver());
        ticketDetails = new TicketDetails(getWebDriver());


    }

    @Test
    public void addCommentInTheTicket(){
        loginPage.openTestPage();
        loginPage.waitUntilLoginPageWillBeOpen();
        loginPage.enterUserName("poshyvailov");
        loginPage.enterUserPassword("poshyvailov");
        loginPage.clickLoginButton();
        loginPage.waitUntilDashboardWillBeOpen();
        jiraMainPage.checkIfJiraMainPageIsFullyOpened();

        // Ждем пока появится строка для поиска тикета, потом вводим номер тикета и нажимаем энтер чтобы открыть его
        jiraMainPage.waitingWhenSearchFieldWillAppear();
        jiraMainPage.typeTicketNameToSearch("WEBINAR-11939");
        jiraMainPage.pressEnterForSearchField();

        // Проверяем, что открылся именно наш тестовый тикет
        ticketDetails.checkIsTicketNameIsPresent();

        //Нажимаем на конопку добавления коммента, ждем пока появится кнопка сохранения коммента и выбираем режим "Text" в поле для коммента
        ticketDetails.clickOnTheAddCommentButton();
        ticketDetails.waitingForSaveCommentButton();
        ticketDetails.goToTextModeForAddingComment();

        // Находим поле для коммента, вводим коммент, проверяем что кнопка сохранения коммента стала активной
        ticketDetails.typeNewCommentToTheCommentField("My random comment");
        ticketDetails.isSaveButtonIsActive();

        // сохраняем коммент и проверяем,что он появился
        ticketDetails.clickOnTheSaveCommentButton();
        ticketDetails.waitingWhenAddNewCommentFieldWillBeClosed();
        ticketDetails.checkIfTestCommentAppeared();

        //Находим иконку удаления коммента, нажимаем на нее и проверяем что поп ап для удаления коммента открылся
        ticketDetails.clickOnTheDeleteCommentIcon();
        ticketDetails.isDeleteConfirmationPopUpIsOpen();

        // Подтверждаем удаление коммента и ждем сообщение об успехе
        ticketDetails.confirmCommentDelete();
        ticketDetails.checkSuccessDeleteMessage();
        //Проверяем,что наш коммент пропал.
        ticketDetails.checkIfCommentIsNotExists();

    }


}
