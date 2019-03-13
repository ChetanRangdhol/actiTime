package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.basePage;

public class loginpage extends basePage

{
	//declartion

	@FindBy(id="username")
	private WebElement usernameTB;
	@FindBy(name="pwd")
	private WebElement passwordTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	@FindBy(xpath="//span[contains(.,' invalid')]")
	private WebElement errorMSG;
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;

	//initialization
	public loginpage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	// utilize
	public void verifyPage(String etitle)
	{
		verifyTitle(etitle);
	}
	public void enterUserName(String un) 
	{
	usernameTB.sendKeys(un);	
	}
	public void enterPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	public String verifyErrorMessage()
	{
		verifyElement(errorMSG);
	String aErrorMessage = errorMSG.getText();
	return aErrorMessage;	
	}
	public String verifyVersion()
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}
	public void clickOnLogin() 
	{
	loginBTN.click();	
	}
	
}
