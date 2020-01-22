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

CustomKeywords.'personas.userPersonas.loginUptimeSmallGroupUser'()

if (WebUI.verifyTextPresent("Join Us For an Upcoming Roundtable Discussion!", false)){
	WebUI.delay(5)
	WebUI.click(findTestObject('RoundtableSplashSceen/continueBtn'))
	WebUI.delay(5)
}

WebUI.delay(5)
WebUI.verifyTextPresent("Ask the Community", false)
WebUI.click(findTestObject('HomePage/askAnUptime'))

WebUI.setText(findTestObject('HomePage/askUptime/question'), 'Test - Query by member having one private group')
WebUI.setText(findTestObject('HomePage/askUptime/comments'), 'Test - Further details put here.')

WebUI.check(findTestObject('HomePage/askUptime/checkbox1'))
WebUI.check(findTestObject('HomePage/askUptime/checkbox2'))
WebUI.check(findTestObject('HomePage/askUptime/checkbox3'))
WebUI.check(findTestObject('HomePage/askUptime/submitBtn'))
WebUI.verifyElementPresent(findTestObject('HomePage/askUptime/successMsgAskUptime'), 3)
WebUI.delay(2)
