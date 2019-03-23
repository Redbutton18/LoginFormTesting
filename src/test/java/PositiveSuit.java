import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PositiveSuit {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
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

    @Test //TestCase4
    public void OnlineHelpTest() {
        loginPage.clickOnlineHelpButton();
        OnlineHelpPage onlineHelpPage = new OnlineHelpPage(driver);
        String headerText3 = onlineHelpPage.getOnlineHelpPageText();
        Assert.assertEquals("Getting Started with Web Director", headerText3);
    }

    @Test //TestCase5
    public void RefreshButtonTest() {
        loginPage.clickRefreshButton();
        String TitleLogin = loginPage.getTitle();
        Assert.assertEquals("Login:", TitleLogin);
    }

    @AfterClass
    public void ShutDown() {
        driver.close();
    }
}
