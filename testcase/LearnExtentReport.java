package testcase;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException   {
	
		//step1:set up physical report path
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./report/result.html");
		
		//To keep the report history
		reporter.setAppendExisting(true);
		
		//step2:Create object for ExtentReport
		ExtentReports extent=new ExtentReports();
		//step3:To attach data with physical file
		extent.attachReporter(reporter);
		//Step4:Create a testcase and assign test detail
		                  //testname    //testDescription
		ExtentTest test = extent.createTest("LoginTest","Login test forleaftaps application");
		test.assignCategory("smoke");
		test.assignAuthor("Hari");
		
		ExtentTest test1 = extent.createTest("Create Test","With mandatory information");
		test1.assignCategory("functional");
		test1.assignAuthor("princila");
		//step5: step level status
		test.pass("Enter username");//if u want use pass() then test will be passed	
		test.pass("Enter password");//if u want use fail() then test will  be failed
		test.pass("click Login button",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/leaff.png").build());
		
		//step6:Mandatory 
		extent.flush();
		
		
	}

}
