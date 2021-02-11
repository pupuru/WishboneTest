package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private static String PAGE_URL = "https://www.wishbone.pl/konto/logowanie";

    @FindBy(tagName = "h2")
    private WebElement loginHeader;
    @FindBy(name = "email")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(css = ".btn.btn-blue")
    private WebElement signInButton;
    @FindBy(className = "create-account")
    private WebElement newAccountLink;
    @FindBy(id = "email-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "password-error")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "//*[@id=\"accWrapper\"]/div/div/form/div/fieldset[1]")
    private WebElement userErrorRedBox;
    @FindBy(xpath = "//*[@id=\"accWrapper\"]/div/div/form/div/fieldset[2]")
    private WebElement passwordErrorRedBox;
    @FindBy(className = "success")
    private WebElement successMessage;


    public SignInPage(WebDriver driver) {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {

        return loginHeader.getText().contains("Zaloguj się");
    }

    public boolean isErrorMsgInvalidEmail() {

        return emailErrorMessage.getText().contains("Niepoprawny adres email");
    }

    public boolean isErrorMsgEmailRequired() {

        return emailErrorMessage.getText().contains("To pole jest wymagane");
    }

    public boolean isErrorMsgInvalidPassword() {

        return passwordErrorMessage.getText().contains("Niepoprawne hasło. Min. 6 znaków");
    }

    public boolean isPasswordFieldRed() {

        return passwordErrorRedBox.isDisplayed();
    }

    public boolean isUserFieldRed() {

        return userErrorRedBox.isDisplayed();
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {

        signInButton.click();
    }
}
