import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {
    WebDriver driver;

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerPrivacyPolicy = By.xpath("/html/body/p[1]/b");

    public String getHeaderText2() {
        return driver.findElement(headerPrivacyPolicy).getText();
    }
}
