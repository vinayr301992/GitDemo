package com.php.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.php.base.BaseClass;

public class ProfileCreation extends BaseClass {

	

	@FindBy(css = "a[href='#profile']")
	WebElement myProfile;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(name = "confirmpassword")
	WebElement confirmPass;
	@FindBy(css = "input[name='address2']")
	WebElement addressText;
	@FindBy(name = "city")
	WebElement cityText;
	@FindBy(name = "state")
	WebElement stateText;
	@FindBy(name = "zip")
	WebElement pinCode;
	@FindBy(xpath = "//div[@class='chosen-container chosen-container-single']")
	WebElement countryExpand;
	@FindBy(css = "input[class='chosen-search-input']")
	WebElement search;
	@FindBys(@FindBy(xpath = "//ul[@class='chosen-results']/li"))
	List<WebElement> dropDownList;
	@FindBy(name = "phone")
	WebElement phoneNumber;
	@FindBy(css = "button[class*='updateprofile']")
	WebElement submitButton;

	public ProfileCreation() {
		PageFactory.initElements(driver, this);
	}

	public void validatingProfileCreation(String pa,String cpa,String at,String ct,String st,String pc,String cout,String ph) throws InterruptedException {

		myProfile.click();
		pass.sendKeys(pa);
		confirmPass.sendKeys(cpa);
		addressText.sendKeys(at);
		cityText.sendKeys(ct);
		stateText.sendKeys(st);
		pinCode.sendKeys(pc);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
		countryExpand.click();
		search.sendKeys(cout);
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfAllElements(dropDownList));
		

		for (int i = 0; i < dropDownList.size(); i++) {

			System.out.println(dropDownList.get(i).getText());
			if (dropDownList.get(i).getText().equals("India")) {

				dropDownList.get(i).click();
				break;

			}

		}

		phoneNumber.sendKeys(ph);
		//submitButton.click();
	}

}
