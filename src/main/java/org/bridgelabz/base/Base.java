package org.bridgelabz.base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports report;

    @BeforeTest
    public void startTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://en-gb.facebook.com/login/");
        Thread.sleep(2000);
        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
    }

    @AfterTest
    public void tearDown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }

}
