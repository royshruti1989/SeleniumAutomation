package base;

import java.lang.reflect.Method;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;
public class BaseTest {
	
	public static WebDriver driver;//because it has to be global variable
	
	public static ExtentReports extent;
    public static ExtentTest test;
	
	@BeforeMethod
	public void setup(Method method) {
		
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(ConfigReader.prop.getProperty("url"));
		 extent = ExtentManager.getInstance();
	     test = extent.createTest(method.getName());
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {

        String screenshotPath = ScreenshotUtil.capture(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {

            test.fail(result.getThrowable())

                .addScreenCaptureFromPath(screenshotPath);

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed")

                .addScreenCaptureFromPath(screenshotPath);

        } else {

            test.skip("Test Skipped");

        }

        extent.flush();

        driver.quit();

    }

}
 
	


