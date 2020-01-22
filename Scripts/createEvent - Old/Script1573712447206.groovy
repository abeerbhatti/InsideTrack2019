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

//Defining Driver and Executor
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = ((driver) as JavascriptExecutor)

WebUI.click(findTestObject('Events/eventsLink'))
WebUI.click(findTestObject('Events/Upcoming/addUpcomingEvent'))

WebUI.verifyTextPresent("Post an Upcoming Event", false)
WebUI.setText(findTestObject('Events/Upcoming/titleUpcomingEvent'), 'Upcoming Event 1-151119')
WebUI.setText(findTestObject('Events/Upcoming/descriptionUpcomingEvent'), 'Upcoming Event 1-151119 Description')
WebUI.setText(findTestObject('Events/Upcoming/location'), 'Test Location')
WebUI.setText(findTestObject('Events/Upcoming/registrationLink'), 'https://www.quora.com/')

//WebUI.click(findTestObject('Events/Upcoming/allDayMultiDay'))
// the above worked!
//WebUI.verifyElementNotChecked(findTestObject('Events/Upcoming/allDayMultiDay'), 3)
//WebUI.verifyElementPresent(findTestObject('Events/Upcoming/eventDate'), 20)

//WebElement eventDateDummy = driver.findElement(By.cssSelector("input[id='event_dummyTextField'][name='event_dummyTextField']"))
////WebUI.executeJavaScript("arguments[0].value='09/20/2019 (12:00 AM)'", eventDate)
//((driver) as JavascriptExecutor).executeScript("arguments[0].value='11/26/2019 (12:00 AM)'", eventDateDummy)

//WebElement eventDate = findTestObject('Events/Upcoming/eventDate')
//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Events/Upcoming/eventDate'), 30)
//WebUI.executeJavaScript("document.getElementById('event_dummyTextField').removeAttribute('readonly');", null)
//WebUI.executeJavaScript("document.getElementById('event.dateTime_value').removeAttribute('readonly');", null)
//WebUI.executeJavaScript("document.getElementById('event.dateTime').removeAttribute('type');", null)

WebUI.executeJavaScript("prefillDate('event.dateTime','11/16/2019 (12:00 AM)')", null)
//WebUI.sendKeys(findTestObject(By.cssSelector("input[id='event_dateTime'][name='event_dateTime']")), '11/20/2019 (12:00 AM)')

//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Events/Upcoming/eventDate'), 30)
//WebUI.executeJavaScript("arguments[0].value = \'11/28/2019 (12:00 AM)\'", Arrays.asList(element))

//driver.findElement(By.cssSelector("input[id='event.dateTime_value'][name='event.dateTime_value']"))
//WebUI.executeJavaScript("arguments[0].value='09/20/2019 (12:00 AM)'", eventDate) 
//((driver) as JavascriptExecutor).executeScript("arguments[0].value='11/26/2019 (12:00 AM)'", eventDate)
//driver.quit()

WebUI.selectOptionByValue(findTestObject('Events/Upcoming/durationInDays'), '3', false)
 
//WebUI.setText(findTestObject('Events/Upcoming/durationInMinutes'), '60')
//WebUI.verifyElementPresent(findTestObject('Events/Upcoming/durationInMinutes'), 20)
WebUI.check(findTestObject('Events/Upcoming/sendAnnouncementNow'))
WebUI.verifyElementPresent(findTestObject('Events/Upcoming/sendAnnouncementNow'), 20)

WebUI.delay(4)
String type = 'Network Conference'
String region = 'Russia'// findTestData('Event').getValue('questionDescription', 1)
//String privateGroup = findTestData('Question').getValue('privateGroup', 1)
//String categoryName = findTestData('Question').getValue('categoryName', 1)

CustomKeywords.'insideTrack.Events.setEventRegion'(region)
CustomKeywords.'insideTrack.Events.setEventType'(type)
CustomKeywords.'insideTrack.Events.setEventVisibility'('SomeEmails')
CustomKeywords.'insideTrack.Events.setEventCategory'('Risk & Resiliency')

WebUI.check(findTestObject('Events/Upcoming/attachFileCheckbox'))
WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/fnd-agile-syllabus_ga.pdf')
WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/Focus-Failure.pdf')
WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/CloudSlides2017_18.pdf')
WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/Survey2018 - 12.pdf')

WebUI.check(findTestObject('Events/Upcoming/shareLinkCheckbox'))
WebUI.setText(findTestObject('commonObjects/linkURLField1'), 'www.quora.com')
WebUI.click(findTestObject('commonObjects/addingtheLink2'))
WebUI.delay(4)

WebUI.click(findTestObject('Events/Upcoming/addMorelinks'))
WebUI.setText(findTestObject('commonObjects/linkURLField2'), 'www.google.com')
WebUI.click(findTestObject('commonObjects/addingtheLink2'))
WebUI.delay(4)

WebUI.click(findTestObject('Events/Upcoming/addMorelinks'))
WebUI.setText(findTestObject('commonObjects/linkURLField3'), 'www.youtube.com')
WebUI.click(findTestObject('commonObjects/addingtheLink2'))
WebUI.delay(4)

WebUI.click(findTestObject('Events/Upcoming/postBtn'))
//WebUI.verifyElementPresent(findTestObject('Events/Upcoming/successMsgEvents'), 2)
WebUI.delay(7)
//WebUI.click(findTestObject('Events/Upcoming/newEventSuccessMsg'))

