import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id=\"username\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By loginButton = By.xpath("//a[@class=\"a_login btn_submit\"]");
    private By linkResetPassword = By.xpath("//a[text()=\"Reset your password\"]");
    private By linkPrivacyPolicy = By.xpath("//a[text()=\"Privacy policy\"]");
    private By errorIncorrectLogPassword = By.xpath("//div[text()=\"Incorrect login or password.\"]");
    private By errorEmptyLogField = By.xpath("//*[@id=\"username-element\"]/span");
    private By errorEmptyPasswField = By.xpath("//*[@id=\"password-element\"]/span");
    private By linkOnlineHelp = By.xpath("//a[@class =\"element place-right\"]");
    private By buttonRefresh = By.xpath("//a[@title=\"Refresh\"]");


    public LoginPage typeLogin (String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public PrereleasePage clickLoginButton () {
        driver.findElement(loginButton).click();
        return new PrereleasePage(driver);
    }

    public ResetPasswordPage clickResetLink () {
        driver.findElement(linkResetPassword).click();
        return new ResetPasswordPage(driver);
    }

    public PrivacyPolicyPage clickPrivicyPolicyLink () {
        driver.findElement(linkPrivacyPolicy).click();
        return new PrivacyPolicyPage(driver);
    }

    public PrereleasePage register (String login, String password) {
        this.typeLogin(login)
                .typePassword(password)
                .clickLoginButton();
        return new PrereleasePage(driver);
    }

    public String getErrorIncorrLogPasswText() {
        return driver.findElement(errorIncorrectLogPassword).getText();
    }

    public String getErrorEmptyLogFieldText() {
        return driver.findElement(errorEmptyLogField).getText();
    }

    public String getErrorEmptyPasswFieldText() {
        return driver.findElement(errorEmptyPasswField).getText();
    }

    public OnlineHelpPage clickOnlineHelpButton () {
        driver.findElement(linkOnlineHelp).click();
        return new OnlineHelpPage(driver);
    }

    public LoginPage clickRefreshButton () {
        driver.findElement(buttonRefresh).click();
        return new LoginPage(driver);
    }

    public String getTitle() {

        return driver.findElement(By.xpath("//label[@for=\"username\"]")).getText();
    }
}

