import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.OrdersPage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    // Checks invalid sign in messages
    public void signInInvalidMsgs() {
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isPageOpened());

        signInPage.clickSignInButton();
        Assert.assertTrue(signInPage.isErrorMsgInvalidPassword());
        Assert.assertTrue(signInPage.isErrorMsgEmailRequired());
    }

    @Test(priority = 2)
    // Checks if nonexistent user can't login
    public void signInInvalidUser() {
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isPageOpened());

        signInPage.setEmail("jasmin@apide.con");
        signInPage.setPassword("qwerty");
        signInPage.clickSignInButton();
        Assert.assertTrue(signInPage.isPasswordFieldRed());
        Assert.assertTrue(signInPage.isUserFieldRed());
    }

    @Test(priority = 3)
    // Checks valid sign in happy path
    public void signIn() {
        SignInPage signInPage = new SignInPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        Assert.assertTrue(signInPage.isPageOpened());

        signInPage.setEmail("jasminhannula@jourrapide.com");
        signInPage.setPassword("qwerty1234");
        signInPage.clickSignInButton();
        Assert.assertTrue(ordersPage.isOrdersPageOpened());
        Assert.assertTrue(ordersPage.IsUserProfileNameCorrect());
        Assert.assertTrue(ordersPage.IsUseEmailDataCorrect());
    }

    @AfterTest
    public void close() {

        driver.close();
    }
}