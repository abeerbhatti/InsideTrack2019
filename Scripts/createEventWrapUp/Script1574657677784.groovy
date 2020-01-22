import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.support.ui.Select as Select
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.openqa.selenium.remote.RemoteWebElement

CustomKeywords.'personas.userPersonas.loginUptimeCommunityMgr'()
WebUI.click(findTestObject('Events/eventsLink'))

String eventTitle = findTestData('EventWrapUp').getValue('eventTitle', 8)
String eventDescription = findTestData('EventWrapUp').getValue('eventDescription', 8)
String location = findTestData('EventWrapUp').getValue('location', 8)
String eventTime = findTestData('EventWrapUp').getValue('eventTime', 8)
String eventKind = findTestData('EventWrapUp').getValue('eventKind', 8)
String region = findTestData('EventWrapUp').getValue('region', 8)
String type = findTestData('EventWrapUp').getValue('Type', 8)
String privateGroup = findTestData('EventWrapUp').getValue('privateGroup', 8)
String categoryName = findTestData('EventWrapUp').getValue('categoryName', 8)

CustomKeywords.'insideTrack.Events.redirectToEventWrapUp'()
CustomKeywords.'insideTrack.Events.setEventWrapUpTitleDescLoc'(eventTitle, eventDescription, location)
CustomKeywords.'insideTrack.Events.setEventTime'(eventTime)

if (eventKind == 'AllDay')//(WebUI.verifyMatch(eventKind, 'AllDay', true, FailureHandling.CONTINUE_ON_FAILURE))
	{
	CustomKeywords.'insideTrack.Events.selectAllDayMultiDay'()
	}
else if (eventKind == 'SameDay')//(WebUI.verifyMatch(eventKind, 'SameDay', true))
	{
	CustomKeywords.'insideTrack.Events.selectSameDayEvent'()
	}

CustomKeywords.'insideTrack.Events.setEventType'(type)
CustomKeywords.'insideTrack.Events.setEventVisibility'(privateGroup)
CustomKeywords.'insideTrack.Events.setEventCategory'(categoryName)
CustomKeywords.'insideTrack.Events.postVerifyEventSuccess'()
