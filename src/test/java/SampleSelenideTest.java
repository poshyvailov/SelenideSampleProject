import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.*;


public class SampleSelenideTest {

    LoginPage loginPage;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName) {
        Configuration.browser = browserName;
        open();
        loginPage = new LoginPage(getWebDriver());
    }


    @Test
    public void loginTest() {
        loginPage.openTestPage();
        loginPage.waitUntilLoginPageWillBeOpen();
        loginPage.enterUserName("poshyvailov");
        loginPage.enterUserPassword("poshyvailov");
        loginPage.clickLoginButton();
        loginPage.waitUntilDashboardWillBeOpen();

    }

}


//        $(By.xpath("//*[@id='dashboard-content']//h1")).shouldBe(Condition.visible);
//         Configuration.assertionMode = Configuration.AssertionMode.SOFT; 
//        Configuration.assertionMode = Configuration.AssertionMode.STRICT; 