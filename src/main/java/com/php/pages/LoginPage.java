package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.BaseClass;

public class LoginPage extends BaseClass {

	
	
	@FindBy(css="input[name='username']") WebElement uname;
	@FindBy(css="input[name='password']") WebElement pass;
	@FindBy(css="button[class*='loginbtn']") WebElement submit;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void validatingLogin(String unameApplication,String passApplication){
		uname.sendKeys(unameApplication);
		pass.sendKeys(passApplication);
		submit.click();
		return ;
		
	}
	
	
	
}
