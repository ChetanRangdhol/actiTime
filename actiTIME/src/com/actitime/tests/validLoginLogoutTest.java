package com.actitime.tests;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.basePage;
import com.actitime.generic.baseTest;
import com.actitime.generic.excelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.loginpage;

public class validLoginLogoutTest extends baseTest
{
@Test
public void testValidLoginLogout()
{
	int i=3;
  while(i!=0)
  {
	String user=excelData.getData(File_Path, "TC01", 1, 0);
	String pass=excelData.getData(File_Path, "TC01", 1, 1);
	String loginTitle=excelData.getData(File_Path, "TC01", 1, 2);
	String EnterTimeTrackTitle=excelData.getData(File_Path, "TC01", 1, 3);
	
	loginpage lp= new loginpage(driver);
	EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
	
	//verify login page
	lp.verifyPage(loginTitle);
	//enter valid user name
	Reporter.log("valid username"+user, true);
	lp.enterUserName(user);
	//enter valid password
	Reporter.log("valid password"+pass, true);
	lp.enterPassword(pass);
	//click onlog in
	lp.clickOnLogin();
	//verify acttitime Enter time track page
	lp.verifyPage(EnterTimeTrackTitle);
	//click on logout
	ep.clickOnLogout();
	//verify page 
	lp.verifyPage(loginTitle);
	i--;
  }

}
}
