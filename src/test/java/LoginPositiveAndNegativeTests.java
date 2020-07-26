import Pages.JiraMainPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class LoginPositiveAndNegativeTests {

    LoginPage loginPage;
    JiraMainPage jiraMainPage;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = browserName;
        open();
        loginPage = new LoginPage(getWebDriver());
        jiraMainPage = new JiraMainPage(getWebDriver());
    }

    @DataProvider(name = "Logins")
    public Object[][] createData(){
        return new Object[][]{
                {"poshyvailov2", "poshyvailov33", "Sorry, your username and password are incorrect - please try again."},
                {"bla bla", " ", "Sorry, your username and password are incorrect - please try again."},
        };
    }

    @Test(dataProvider = "Logins")
    public void loginWithWrongData(String userName, String userPass, String expectedResult)throws InterruptedException{
        loginPage.openTestPage();
        loginPage.enterUserName(userName);
        loginPage.enterUserPassword(userPass);
        loginPage.clickLoginButton();
        loginPage.isErrorsMessageIsShown(expectedResult);
    }

    @Parameters({"browserName"})
    @Test()
    public void positiveLoginTest(String browserName){
        System.out.println("Browser name from parameters is: " + browserName);
        loginPage.openTestPage();
        loginPage.waitUntilLoginPageWillBeOpen();
        loginPage.enterUserName("poshyvailov");
        loginPage.enterUserPassword("poshyvailov");
        loginPage.clickLoginButton();
        loginPage.waitUntilDashboardWillBeOpen();
    }


}
