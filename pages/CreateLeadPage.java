package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class CreateLeadPage extends ProjectSpecificMethod {
	public CreateLeadPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	
	}
	
	public CreateLeadPage enterCompanyName(String cmp) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmp);

			reportStep(cmp+"companyName is enter successfully","pass");
		}
		catch(Exception e){
			reportStep("Wrongly enter company Name"+e,"fail");
		}
			     return this;
	}
public CreateLeadPage enterFirstName(String fname) {
	
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	return this;
	}
public CreateLeadPage enterLastName(String lname) {
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	return this;
}
public ViewLead clickCreatebutton() {
	
	driver.findElement(By.name("submitButton")).click();
	return new ViewLead(driver,node);
	
}

}
