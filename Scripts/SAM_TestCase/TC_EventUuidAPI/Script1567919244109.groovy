import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

response = WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSLoginAPI'))

//fetching token from response header
String[] token = response.getHeaderFields().get('x-nextinteract-authtoken')

//Setting global varibale token
GlobalVariable.token = token[0]
println('The token value is '+GlobalVariable.token)

WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSGetEventUUID'))

WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSGetEventsUUID'))

WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSAcceptRejectEventInvite'))

WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSUpdateEventAttendanceStatus'))

WS.sendRequestAndVerify(findTestObject('SAM_CreateEventAPI/WSGetEventBrochuresForUser'))

