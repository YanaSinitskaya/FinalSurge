package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BasePage basePage;
    WorkoutPage workoutPage;
    CalculatorPage calculatorPage;
    QuickAddWorkoutPage quickAddWorkoutPage;
    CalendarPage calendarPage;

    public static final String USER = "asya.gadzhiyan@gmail.com";
    public static final String PASSWORD = "1408asyA!";


    @Parameters({"browser"})
    @BeforeMethod(description = "Browser settings")
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            } else if(browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        workoutPage = new WorkoutPage(driver);
        quickAddWorkoutPage = new QuickAddWorkoutPage(driver);
        calculatorPage = new CalculatorPage(driver);
        calendarPage = new CalendarPage(driver);

        String user = System.getenv().getOrDefault("user", PropertyReader.getProperty("sf.user"));
        System.out.println(user);
        String password = System.getenv().getOrDefault("password", PropertyReader.getProperty("sf.password"));
        System.out.println(password);
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }
}