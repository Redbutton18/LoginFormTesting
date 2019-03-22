import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NegativeSuit {
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
    public void AllEmptyFieldsTest() {
        loginPage.register("", "");
        String error = loginPage.getError2Text();
        String error2 = loginPage.getError3Text();
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error);
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error2);
    }

    @Test //TestCase2
    public void EmptyLoginField() {
        loginPage.register("", "ABC123");
        String error3 = loginPage.getError2Text();
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error3);
    }

    @Test //TestCase3
    public void EmptyPasswordField() {
        loginPage.register("TestUser1", "");
        String error4 = loginPage.getError3Text();
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error4);
    }

    @Test //TestCase4
    public void IncorrectPasswordField() {
        loginPage.register("TestUser1", "ABC1234");
        String error5 = loginPage.getError1Text();
        Assert.assertEquals("Incorrect login or password.", error5);
    }

    @Test //TestCase5
    public void IncorrectLoginField() {
        loginPage.register("TestUser2", "ABC123");
        String error5 = loginPage.getError1Text();
        Assert.assertEquals("Incorrect login or password.", error5);
    }

    @Test //TestCase6
    public void BothIncorrectField() {
        loginPage.register("TestUser2", "ABC1234");
        String error5 = loginPage.getError1Text();
        Assert.assertEquals("Incorrect login or password.", error5);
    }

    @Test //TestCase7
    public void BothSpacesField() {
        loginPage.register("     ", "     ");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCase8
    public void BeginWithSpacesField() {
        loginPage.register("  TestUser1", "  ABC123");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCase9
    public void EndingWithSpacesField() {
        loginPage.register("TestUser1  ", "ABC123  ");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCase10
    public void LoginWithRegister() {
        loginPage.register("tEStuSer1", "ABC123");
        String error7 = loginPage.getError1Text();
        Assert.assertEquals("Not valid field", error7);
    }

    @Test //TestCas11
    public void SpecialCharactersUsage() {
        loginPage.register("@#$%&*!", "@#$%&*!");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCas12
    public void CyrillicAlphabetUsage() {
        loginPage.register("ФпоЗпр", "мсШсмиТ");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCas13
    public void SQLInjectionUsage() {
        loginPage.register("Robert'); DROP TABLE Students;--", "Robert'); DROP TABLE Students;--");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCas14
    public void JSInjectionUsage() {
        loginPage.register("Nice site,  I think I'll take it. <script>alert('Executing JS')</script>", "Nice site,  I think I'll take it. <script>alert('Executing JS')</script>");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCas15
    public void MaxFieldsLength() {
        loginPage.register("James Dr No From Russia with Love Goldfinger Thunderball You Only Live Twice On Her Majesty’s Secret Service Diamonds Are Forever Live and Let Die The Man with the Golden Gun The Spy Who Loved Me Moonraker For Your Eyes Only Octopussy A View to a Kill The Living Daylights Licence to Kill Golden Eye Tomorrow Never Dies The World Is Not Enough Die Another Day Casino Royale Bond", "123.456,789.098.765,432.");
        String error6 = loginPage.getError2Text();
        Assert.assertEquals("Not valid field", error6);
    }

    @Test //TestCas16
    public void MinFieldsLength() {
        loginPage.register("aA", "01");
        String error7 = loginPage.getError2Text();
        String error8 = loginPage.getError3Text();
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error7);
        Assert.assertEquals("Field can't be empty and less then 3 symbol", error8);
    }

    @After
    public void ShutDown() {
        driver.close();
    }
}
