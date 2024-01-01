package base;

import Utilities.Helper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
    //public void startDriver( String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }  else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe");
            driver = new OperaDriver();
            WebDriver webDriver=new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(caps);
            driver = new ChromeDriver(option);
        }
       driver.manage().deleteAllCookies();
        driver.get("http://hiring.petroapp.com/test2.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closeDriver(ITestResult result) throws IOException {
        String testCaseName = result.getMethod().getMethodName();
        File destFile =  new File("Screenshots"+File.separator+testCaseName+".png");
       takesScreenshot(destFile);
        driver.quit();
    }
    public void takesScreenshot(File destFile) throws IOException {
        File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,destFile);
        InputStream is =new FileInputStream(destFile);
        Allure.addAttachment("screenshot",is);
    }
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(driver, result.getName());
        }
    }

    }
