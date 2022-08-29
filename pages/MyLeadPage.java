package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class MyLeadPage extends ProjectSpecificMethod{
	public MyLeadPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	
	}
	

	public CreateLeadPage clickcreatelead() {
		
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage (driver,node);
		
}
}
