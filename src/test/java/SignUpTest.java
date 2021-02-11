import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignInPageAfterRegistration;
import pages.SignUpPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class SignUpTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    //Checks if a new user can be registered successfully
    public void signIn() {
        SignUpPage signUpPage = new SignUpPage(driver);
        SignInPageAfterRegistration successPage = new SignInPageAfterRegistration(driver);
        UUID uuid = UUID.randomUUID();

        Assert.assertTrue(signUpPage.isPageOpened());
        signUpPage.setName("Hannah");
        signUpPage.setLastName("Jasmin");
        signUpPage.setEmail("jasminhannula+" + uuid + "@jourrapide.com");
        signUpPage.setPassword("qwerty1234");
        signUpPage.clickCheckbox();
        signUpPage.clickSignUpButton();
        Assert.assertTrue(successPage.isSuccessMessageDisplayed());
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}