package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    @FindBy(tagName = "h2")
    private WebElement userHeader;
    @FindBy(className = "user-link")
    private WebElement userNameLink;
    @FindBy(className = "client-main-info")
    private WebElement userEmail;

    public OrdersPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    public boolean isOrdersPageOpened() {
        return userHeader.getText().contains("Dane kupującego");
    }

    public boolean IsUserProfileNameCorrect() {
        return userNameLink.getText().contains("JASMIN HANNULA");
    }
    public boolean IsUseEmailDataCorrect() {
        return userEmail.getText().contains("jasminhannula@jourrapide.com");
    }


}