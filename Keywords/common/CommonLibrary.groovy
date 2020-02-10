package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CommonLibrary {
	@Keyword
	def navigateToURL(){

		String env = findTestData('Environments').getValue(2, 1) //to get value from enviornment data file
		WebUI.openBrowser(env)
		WebUI.maximizeWindow()
		WebUI.delay(5)

	}
	@Keyword
	def closeOpenBrowser() {
		WebUI.closeBrowser()
	}
	@Keyword
	def loginSAM(String testCaseName,String email, String password){
		if(WebUI.verifyElementPresent(findTestObject('SAM_Login/btnCookies'), 10)){
			WebUI.click(findTestObject('SAM_Login/btnCookies'))
		}
		int i =1
		def maxRow = findTestData('SAMTestData').getRowNumbers()
		println maxRow
		while (i<=maxRow)
		{
		if (findTestData('SAMTestData').getValue('TestCaseName',i)==testCaseName)
			{
				WebUI.setText(findTestObject('SAM_Login/txtUserName'), findTestData('SAMTestData').getValue('Email', i))
				WebUI.click(findTestObject('SAM_Login/btnNext'))
				WebUI.setText(findTestObject('SAM_Login/txtPassword'), findTestData('SAMTestData').getValue('Password', i))
				WebUI.refresh()
			}
			i++
		}
		//WebUI.click(findTestObject('SAM_Login/btnLogin'))
		WebUI.delay(3)
	}
}
