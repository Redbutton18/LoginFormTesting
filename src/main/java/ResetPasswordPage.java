import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerText = By.xpath("//div[text()=\" Please enter the email address associated with your login.\"]");

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }
}
