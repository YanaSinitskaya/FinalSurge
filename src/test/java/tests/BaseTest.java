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

import java.time.Duration;
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BasePage basePage;
    WorkoutPage workoutPage;
    CalculatorPage calculatorPage;
    QuickAddWorkoutModalPage quickAddWorkoutModalPage;
    QuickAddWorkoutListPage quickAddWorkoutListPage;
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
        quickAddWorkoutModalPage = new QuickAddWorkoutModalPage(driver);
        quickAddWorkoutListPage = new QuickAddWorkoutListPage(driver);
        calculatorPage = new CalculatorPage(driver);
        calendarPage = new CalendarPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }
}

