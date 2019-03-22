import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrereleasePage {
    WebDriver driver;

    public PrereleasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashboardElement = By.xpath("//div[@onclick=\"goToTablesView()\"]//span[text()=\"Dashboard\"]");

    public String getHeaderText() {
       return driver.findElement(dashboardElement).getText();
    }
}
