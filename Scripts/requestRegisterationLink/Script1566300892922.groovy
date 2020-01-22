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
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')

WebUI.click(findTestObject('RequestRegistrationLink/requestRegisterationLink'))
WebUI.verifyTextPresent("Request Your Personal Registration Link!", false)

WebUI.setText(findTestObject('RequestRegistrationLink/name'), 'Test Name A')
WebUI.setText(findTestObject('RequestRegistrationLink/email'), 'abeer.bhatti+TestNameA@conradlabs.com')
WebUI.setText(findTestObject('RequestRegistrationLink/title'), 'Title for Test Name A')
WebUI.setText(findTestObject('RequestRegistrationLink/company'), 'Company for Test Name A')

String expectedPlaceholder = "Please send my registration link for Uptime Institute."
String placeholder = WebUI.getText(findTestObject('RequestRegistrationLink/message'))

if (expectedPlaceholder != placeholder){
	KeywordUtil.markFailed("Placeholder is not as expected.")
}

WebUI.verifyTextPresent("Or, call Member Services at (240) 200-3987", false)
WebUI.click(findTestObject('RequestRegistrationLink/submitBtn'))
WebUI.verifyElementPresent(findTestObject('RequestRegistrationLink/successRegistrationLink'), 2)