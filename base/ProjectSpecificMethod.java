package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LearnReadExcel;


public class ProjectSpecificMethod {
	
	public  ChromeDriver driver;
	public String excelfile;
	public ExtentHtmlReporter reporter;
	public static  ExtentReports extent;//keep extent global
	public ExtentTest test,node;//keep ExtentTest global
	public  String testName,testDescription,testCategory,testAuthor;
	@BeforeSuite
	public void startReport() {
				reporter=new ExtentHtmlReporter("./report/result.html");
				reporter.setAppendExisting(true);
				extent=new ExtentReports();
				extent.attachReporter(reporter);
	}
	@BeforeClass
	public void setTestCasedetail() {
		test= extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
	}
	public int takeSnapShot() throws IOException {
		//how to generate random number
		int ranNum=(int)(Math.random()*999999+10000000);//1113423
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destin=new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, destin);
		return ranNum;

	}
	public void reportStep(String stepDesc, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnapShot()+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnapShot()+".png").build());
			throw new RuntimeException("Please look into report for failure details");
		}
	}
	
	@DataProvider(name="testData")
	public String[][] fetchdata() throws IOException {
		String[][] readData = LearnReadExcel.readData(excelfile);
		return readData;
	}
	@BeforeMethod
	public void preCondition() {
		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	
	
}
