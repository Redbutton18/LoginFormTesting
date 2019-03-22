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
    private By error1 = By.xpath("//div[text()=\"Incorrect login or password.\"]");
    private By error2 = By.xpath("//*[@id=\"username-element\"]/span");
    private By error3 = By.xpath("//*[@id=\"password-element\"]/span");
    //private By errorNotValidField = By.xpath("//*[@id=\"username-element\"]/span");


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

    public String getError1Text() {
        return driver.findElement(error1).getText();
    }

    public String getError2Text() {
        return driver.findElement(error2).getText();
    }

    public String getError3Text() {
        return driver.findElement(error3).getText();
    }
}
