package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	public LoginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	
	}
	
	
//element/action
	public LoginPage enterUsername(String uname) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(uname);
			reportStep(uname+"username is enter successfully","pass");
		}
		catch(Exception e){
			reportStep("username is wrongly Enter"+e,"fail");
		}
		return this;
	}
    public LoginPage enterPassword(String pwd) throws IOException {
    	try {
    		driver.findElement(By.id("password")).sendKeys(pwd);
    	reportStep(pwd+"password is enter successfully","pass");
	}
	catch(Exception e){
		reportStep("password is wrongly Enter"+e,"fail");
	}
    	
    	return this;
	}
    public HomePages clickLogin() throws IOException {
    	try {
    		driver.findElement(By.className("decorativeSubmit")).click();
    		reportStep("Login button is clicked","pass");
    	}
    	catch(Exception e){
    		reportStep("Login button is not clicked"+e,"fail");
    	}
    	
    	
      return new HomePages(driver,node);
	}
}
