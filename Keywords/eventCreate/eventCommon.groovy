package eventCreate

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
import org.openqa.selenium.Keys

import internal.GlobalVariable

public class eventCommon {

	@Keyword
	def selectCompany(String company){
		WebUI.delay(3)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/linkSuperUser'))
		WebUI.setText(findTestObject('SAMEventCreate/SuperUserCompany/txtSearchCompany'), company)
		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('SAMEventCreate/SuperUserCompany/txtSearchCompany'), Keys.chord(Keys.ENTER))
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/btnCompanyRow'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/btnMyInteract'))
		WebUI.delay(3)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/btnMyEvent'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/btnAddEvent'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/SuperUserCompany/btnEventDetailsTab'))
	}

	@Keyword
	def addEventDetails(String eventName, String eventType, String eventDetails, String address, String startDate, String endDate, String timeZone ){
		WebUI.delay(3)
		WebUI.setText(findTestObject('SAMEventCreate/EventDetails/txtEventName'),eventName)
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnEventType'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/selectEventType',[('eventType') : eventType]))
		WebUI.delay(1)
		WebUI.setText(findTestObject('SAMEventCreate/EventDetails/txtEventDetails'),eventDetails)
		WebUI.delay(1)
		//Set Location...........
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/imgSetLocation'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('SAMEventCreate/EventDetails/txtSearchGoogleMap'),address)
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnGoogleSearch'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/selectGoogleSearchedLocation',[('searchedLocation') : address]))
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnLocationOkButton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnLocationSave'))
		//Set Start date and End Date
		WebUI.delay(2)
		WebUI.setText(findTestObject('SAMEventCreate/EventDetails/txtEventStartDate'),startDate)
		WebUI.delay(1)
		WebUI.setText(findTestObject('SAMEventCreate/EventDetails/txtEventEndDate'),endDate)
		//Set TimeZone
		WebUI.delay(1)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/imgSetTimeZone'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnSaveTimeZone'))
		WebUI.delay(2)
		WebUI.click(findTestObject('SAMEventCreate/EventDetails/btnSaveEventDetails'))
	}
}
