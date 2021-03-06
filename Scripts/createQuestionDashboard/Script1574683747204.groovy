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
	WebUI.click(findTestObject('RoundtableSplashSceen/continueBtn'))
}

WebUI.waitForElementNotVisible(findTestObject('RoundtableSplashSceen/mainLabel'), 20, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyTextPresent("Ask the Community", false)

String questionName = findTestData('Question').getValue('question', 2)
String questionDescription = findTestData('Question').getValue('questionDescription', 2)
String privateGroup = findTestData('Question').getValue('privateGroup', 2)
String categoryName = findTestData('Question').getValue('categoryName', 2)

WebUI.setText(findTestObject('HomePage/questionBox'), questionName)
WebUI.click(findTestObject('HomePage/continueBtn'))
WebUI.setText(findTestObject('DiscussionsPage/Questions/questionDescription'), questionDescription)
CustomKeywords.'insideTrack.Discussions.setQuestionTitleandDetail'(questionName, questionDescription)
CustomKeywords.'insideTrack.Content.setVisibility'(privateGroup)
CustomKeywords.'insideTrack.Content.setCategories'(categoryName)
CustomKeywords.'insideTrack.Discussions.discussionClickPreviewandPost'()
CustomKeywords.'insideTrack.Discussions.verifyQuestionSuccess'()