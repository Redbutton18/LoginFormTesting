import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineHelpPage {
    WebDriver driver;

    public OnlineHelpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageContentsText = By.xpath("//span[text()=\"Getting Started with Web Director\"]");


    public String getOnlineHelpPageText() {

        return driver.findElement(pageContentsText).getText();
    }
}
