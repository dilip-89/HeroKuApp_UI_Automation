package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import testreportbuilder.ExtentTestNGReportBuilder;
import util.PropertyReader;
import util.TestConfiguration;
import utils.CommonOperations;
import utils.ExcelReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebConfig extends ExtentTestNGReportBuilder {

    public WebDriver driver;
    public ExcelReader excel;
    public CommonOperations commonOperations;

    public String[][] getData(String sheetname, String excelname) {
        excel = new ExcelReader(System.getProperty("user.dir") + "/src/main/resources/Data/" + excelname);
        return excel.getDataFromSheet(sheetname, excelname);
    }

    @BeforeTest
    @Parameters({"browser", "Product"})
    public void setupBrowserAndURL(String browser, String Product) throws Exception {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("window-size=1400,2100");
            chromeOptions.addArguments("--disable-gpu");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }else {
            throw new Exception("Browser is not correct in xml :" + browser);
        }
        this.urlSetup(Product);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        takeSnapShot(driver, TestConfiguration.OUTPUT_FOLDER + TestConfiguration.SPECIAL_CAPTURE_FOLDER + methodName
                + System.currentTimeMillis() + ".png");
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
    public void urlSetup(String Product) throws Exception {
        PropertyReader propertyReader = new PropertyReader();
        String applicationProperty = TestConfiguration.prepareApplicationPropertyPrefix(Product);
        driver.get(propertyReader.get(applicationProperty));
        commonOperations = new CommonOperations(driver);
        commonOperations.waitUntilPageLoaded(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        String outputImageFolder = TestConfiguration.OUTPUT_FOLDER + "/ScreenCaptures/";
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src,
                        new File(outputImageFolder + result.getName() + "_" + System.currentTimeMillis() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
