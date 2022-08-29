package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod {
	public MyHomePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	
	}
	

	public MyLeadPage clickLead() {
	
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadPage(driver,node);
}
}
