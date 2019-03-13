package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.baseTest;
import com.actitime.generic.excelData;
import com.actitime.pages.loginpage;

public class invalidLoginTest extends baseTest
{
@Test(priority=2)
public void  testInvalidlogin() throws InterruptedException
{
	String loginTitle=excelData.getData(File_Path, "TC01", 1, 2);
	String expectedErrorMessage=excelData.getData(File_Path, "TC02", 1, 2);
	loginpage lp=new loginpage(driver);
	
	//verify login page
	lp.verifyPage(loginTitle);
	int rc= excelData.getRowCount(File_Path, "TC02");
	for (int i =1;i<=rc;i++)
	{
		String user = excelData.getData(File_Path, "TC02", i, 0);
		String pass=excelData.getData(File_Path, "TC02", i, 1);
	//enter invalid user name 
		Reporter.log("invalid user"+user, true);
		lp.enterUserName(user);
	//enter invalid pass
		Reporter.log("invalid pass"+pass, true);
		lp.enterPassword(pass);
	// click login
		lp.clickOnLogin();
		Thread.sleep(1000);
	//verify error msg
		String actualErrorMessage=lp.verifyErrorMessage();
		Reporter.log("actual Error Message"+actualErrorMessage, true);
		Reporter.log("expected error message"+expectedErrorMessage, true);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		Reporter.log("error msg is matching", true);
		Reporter.log("=====================", true);
	}
}


}
