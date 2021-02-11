package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageAfterRegistration {

    @FindBy (className = "success")
    private WebElement successMessage;


    public SignInPageAfterRegistration(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.getText().toString().contains("Twoje konto zostało założone. Aby je aktywować, kliknij link w wiadomości e-mail.");
    }

}