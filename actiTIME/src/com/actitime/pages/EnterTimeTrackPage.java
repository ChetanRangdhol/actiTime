package com.actitime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.basePage;

public class EnterTimeTrackPage extends basePage
{
    //declaration
	@FindBy(id ="logoutLink")
	private WebElement logoutBTN;
	@FindBy(css="div[onclick='openHelpAndSupportMenu(event)']")
	private WebElement helpBTN;
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutBTN;
	@FindBy(xpath="//span[contains(.,'build')]")
	private WebElement buildTXT;
	//intialization
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void clickOnLogout()
	{
		new loginpage(driver).verifyElement(logoutBTN);
		logoutBTN.click();
	}
	public void clickOnHelp()
	{
		new loginpage(driver).verifyElement(helpBTN);
		helpBTN.click();
	}
	public void clickOnabout()
	{
		aboutBTN.click();
	}
	public String verifyBuild()
	{
		verifyElement(buildTXT);
		String aBuild=buildTXT.getText();
		return aBuild;
	}
	
}
