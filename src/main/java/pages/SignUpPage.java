package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private static String PAGE_URL = "https://www.wishbone.pl/konto/rejestracja";

    @FindBy(tagName = "h2")
    private WebElement signInHeader;
    @FindBy(name = "name")
    private WebElement nameField;
    @FindBy(name = "last_name")
    private WebElement lastNameField;
    @FindBy(name = "email")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"accWrapper\"]/div/div/form/div/fieldset[5]/div/label")
    private WebElement checkbox;
    @FindBy(css = ".btn.btn-blue")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {

        return signInHeader.getText().contains("Załóż konto");
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickCheckbox() {
        checkbox.click();

    }

    public void clickSignUpButton() {
        signUpButton.click();

    }
}