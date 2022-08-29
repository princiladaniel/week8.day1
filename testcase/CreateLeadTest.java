package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class CreateLeadTest extends ProjectSpecificMethod{
	@BeforeTest
	public void setValues() {
		excelfile="CreateLeadpom";
		testName="CreateLead";
		testDescription="Create lead with mandatory information";
		testCategory="functional";
	    testAuthor="Princila";
	}
	@Test(dataProvider="testData")
	public void runCreateLead(String uname,String pwd,String cmp,String fname,String lname) throws IOException {
  LoginPage lp=new LoginPage(driver,node);
  System.out.println(driver);
  lp.enterUsername(uname).enterPassword(pwd).clickLogin().clickCrmsfa().clickLead()
  .clickcreatelead().enterCompanyName(cmp).enterFirstName(fname).enterLastName(lname).clickCreatebutton()
  .verifyLead(fname);

  }
	}


