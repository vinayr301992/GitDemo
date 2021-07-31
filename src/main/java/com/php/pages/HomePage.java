package com.php.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.php.base.BaseClass;

public class HomePage extends BaseClass {

	
	
	@FindBy(xpath="//div[@class='dropdown dropdown-login dropdown-tab']") WebElement myAccount;
	@FindBys(@FindBy(xpath="//div[@class='']/a")) List<WebElement> dropDownList;
	@FindBy(css="a[href*='login']") WebElement loginLink;
	@FindBy(css="a[href*='register']") WebElement signUpLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void validatingMyAccountLogin(){
		
		myAccount.click();
		for(int i=0;i<dropDownList.size();i++)   {
			
			System.out.println(dropDownList.get(i).getText());
			if(dropDownList.get(i).getText().contains("Login"))   {
				
				dropDownList.get(i).click();
				break;
				
			}
			
		}
		
	}
	
	public WebElement validatingSignUpLink(){
		signUpLink.click();
		return signUpLink;
	}
	
}
