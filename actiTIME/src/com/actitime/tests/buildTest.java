package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.baseTest;
import com.actitime.generic.excelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.loginpage;

public class buildTest extends baseTest
{
	@Test(priority=4)
	public void testBuild()
	{
		String user=excelData.getData(File_Path, "TC01", 1, 0);
		String pass=excelData.getData(File_Path, "TC01", 1, 1);
		String loginTitle=excelData.getData(File_Path, "TC01", 1, 2);
		String EnterTimeTrackTitle=excelData.getData(File_Path, "TC01", 1, 3);
		String build=excelData.getData(File_Path, "TC04", 1, 0);
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
		
		//click on log in
		lp.clickOnLogin();
		
		//verify actitime Enter time track page
		lp.verifyPage(EnterTimeTrackTitle);
		
		//click on help
		ep.clickOnHelp();
		
		//click on about
		ep.clickOnabout();
		
		//verify the build
		String actualBuild=ep.verifyBuild();
		Reporter.log("actual build"+actualBuild, true);
		Reporter.log("Expected build"+build, true);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualBuild, build);
		sa.assertAll();
		Reporter.log("build is matching"+actualBuild, true);
	
	}
	

}
