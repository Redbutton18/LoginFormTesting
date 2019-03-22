import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PositiveSuit {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void SetUp() {

        System.setProperty("webdriver.cromedriver", "C:\\Users\\Redbutton\\IdeaProjects\\testloginpagefintegro\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://autotest-prerelease.intesting.ca/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test //TestCase1
    public void LoginTest() {
        loginPage.register("TestUser1", "ABC123");
        PrereleasePage prereleasePage = new PrereleasePage(driver);
        String headerSiteText = prereleasePage.getHeaderText();
        Assert.assertEquals("Dashboard", headerSiteText);
    }

    @Test //TestCase2
    public void ResetTest() {
        loginPage.clickResetLink();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        String headerText = resetPasswordPage.getHeaderText();
        Assert.assertEquals("Please enter the email address associated with your login.", headerText);
    }

    @Test //TestCase3
    public void PrivacyPolicyTest() {
        loginPage.clickPrivicyPolicyLink();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driver);
        String headerText2 = privacyPolicyPage.getHeaderText2();
        Assert.assertEquals("PRIVACY POLICY", headerText2);
    }

    @After
    public void ShutDown() {
        driver.close();
    }
}
