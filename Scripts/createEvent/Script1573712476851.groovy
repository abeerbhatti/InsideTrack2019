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

//CustomKeywords.'personas.userPersonas.loginUptimeCommunityMgr'()
WebUI.click(findTestObject('Events/eventsLink'))

String eventTitle = findTestData('Events').getValue('eventTitle', GlobalVariable.i)
String eventDescription = findTestData('Events').getValue('eventDescription', GlobalVariable.i)
String location = findTestData('Events').getValue('location', GlobalVariable.i)
String registerationLink = findTestData('Events').getValue('registerationLink', GlobalVariable.i)
String eventTime = findTestData('Events').getValue('eventTime', GlobalVariable.i)
String eventKind = findTestData('Events').getValue('eventKind', GlobalVariable.i)
String region = findTestData('Events').getValue('region', GlobalVariable.i)
String type = findTestData('Events').getValue('Type', GlobalVariable.i)
String privateGroup = findTestData('Events').getValue('privateGroup', GlobalVariable.i)
String categoryName = findTestData('Events').getValue('categoryName', GlobalVariable.i)

WebUI.click(findTestObject('Events/Upcoming/addUpcomingEvent'))

CustomKeywords.'insideTrack.Events.setEventTitleDescLocReglink'(eventTitle, eventDescription, location, registerationLink)
CustomKeywords.'insideTrack.Events.setEventTime'(eventTime)

if (eventKind == 'AllDay')//(WebUI.verifyMatch(eventKind, 'AllDay', true, FailureHandling.CONTINUE_ON_FAILURE))
	{
	CustomKeywords.'insideTrack.Events.selectAllDayMultiDay'()
	}
else if (eventKind == 'SameDay')//(WebUI.verifyMatch(eventKind, 'SameDay', true))
	{
	CustomKeywords.'insideTrack.Events.selectSameDayEvent'()
	}

CustomKeywords.'insideTrack.Events.selectSendAnnouncementNow'()
CustomKeywords.'insideTrack.Events.setEventRegion'(region)
CustomKeywords.'insideTrack.Events.setEventType'(type)
CustomKeywords.'insideTrack.Events.setEventVisibility'(privateGroup)
CustomKeywords.'insideTrack.Events.setEventCategory'(categoryName)
//CustomKeywords.'insideTrack.Events.attachFiles'()
//CustomKeywords.'insideTrack.Events.sharedLink'()
CustomKeywords.'insideTrack.Events.postVerifyEventSuccess'()

