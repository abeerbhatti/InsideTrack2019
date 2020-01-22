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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
CustomKeywords.'personas.userPersonas.loginUptimeCommunityMgr'()

WebUI.click(findTestObject('HomePage/memberLink'))
WebUI.verifyTextPresent('All Members', false)
WebUI.click(findTestObject('referYourColleague/referaColleaguelink'))
WebUI.verifyTextPresent('Refer Your Colleagues to Inside Track!', false)
String expectedPlaceholder = 'Please list names, email addresses, and titles of colleagues you would like to refer.'
String placeholdercurrent = WebUI.getAttribute(findTestObject('referYourColleague/requestedNames'), 'placeholder')

if (expectedPlaceholder != placeholdercurrent) {
    KeywordUtil.markFailed('Placeholder is not as expected.')
}

WebUI.verifyMatch(placeholdercurrent, expectedPlaceholder, false)
String Message = 'Please provide an Inside Track registration link to the names, emails and titles listed above.'
String placeholderMessage = WebUI.getText(findTestObject('referYourColleague/message'))
WebUI.verifyMatch(Message, placeholderMessage, false)
WebUI.setText(findTestObject('referYourColleague/requestedNames'), 'Name 1:abcd')
WebUI.sendKeys(findTestObject('referYourColleague/requestedNames'), Keys.chord(Keys.ENTER))
WebUI.sendKeys(findTestObject('referYourColleague/requestedNames'), 'Name 2:xyz')
WebUI.sendKeys(findTestObject('referYourColleague/requestedNames'), Keys.chord(Keys.ENTER))
WebUI.sendKeys(findTestObject('referYourColleague/requestedNames'), 'Name 3:efg')
WebUI.click(findTestObject('referYourColleague/submitBtn'))
WebUI.verifyElementPresent(findTestObject('referYourColleague/successReferYourColleagues'), 2)
