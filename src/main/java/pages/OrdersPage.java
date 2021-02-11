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

    public OrdersPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    public boolean isPageOpened() {
        return userHeader.getText().contains("Dane kupującego");
    }

    public boolean isUserCorrect() {
        return userNameLink.getText().contains("JASMIN HANNULA");
    }


}