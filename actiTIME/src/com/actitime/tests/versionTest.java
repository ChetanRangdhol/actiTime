package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.baseTest;
import com.actitime.generic.excelData;
import com.actitime.pages.loginpage;

public class versionTest extends baseTest
{
@Test(priority=3)
public void testVerifyVersion()
{
	String loginTitle=excelData.getData(File_Path, "TC01", 1, 2);
	String expectedVersion=excelData.getData(File_Path, "TC03", 1, 0);
	loginpage lp=new loginpage(driver);
	
	//verify log in page
	lp.verifyPage(loginTitle);
	
	//verify version
	String actualVersion=lp.verifyVersion();
	Reporter.log("Actual version:"+actualVersion, true);
	Reporter.log("expected version:"+expectedVersion, true);
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(actualVersion, expectedVersion);
	sa.assertAll();
	Reporter.log("version is matching ....",true);
	
}

}
