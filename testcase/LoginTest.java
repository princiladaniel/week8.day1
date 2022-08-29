package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class LoginTest extends ProjectSpecificMethod {
	@BeforeTest
	public void setValue() {
		excelfile="Login";
		
		testName="LoginTest";
		testDescription="Login leaf tap application";
		testCategory="smoke";
	    testAuthor="Edward";
	}
	@Test(dataProvider="testData")
	
	public void runLogin(String uname,String pwd) throws IOException {
		LoginPage lp=new LoginPage(driver,node);
		lp.enterUsername(uname).enterPassword(pwd).clickLogin();
		
		
	}

}
