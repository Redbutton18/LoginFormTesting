import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.cromedriver", "C:\\Users\\Redbutton\\IdeaProjects\\testloginpagefintegro\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://autotest-prerelease.intesting.ca/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.register("test", "1234");


    }
}
