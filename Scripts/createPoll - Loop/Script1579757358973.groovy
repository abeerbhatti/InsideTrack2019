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
CustomKeywords.'insideTrack.Discussions.landatDiscussionsListPage'()

int TotalRows = findTestData('Polls').getRowNumbers()
for (GlobalVariable.i=1; GlobalVariable.i<=TotalRows; GlobalVariable.i++){ 
	
	System.out.println("Number " + GlobalVariable.i + " of " + TotalRows + " Polls Enteries")
	CustomKeywords.'insideTrack.Discussions.addPoll'()
	String pollName = findTestData('Polls').getValue('Poll', GlobalVariable.i)
	String pollDescription = findTestData('Polls').getValue('pollDescription', GlobalVariable.i)
	String privateGroup = findTestData('Polls').getValue('privateGroup', GlobalVariable.i)
	String categoryName = findTestData('Polls').getValue('categoryName', GlobalVariable.i)
	String optionA = findTestData('Polls').getValue('Answer1', GlobalVariable.i)
	String optionB = findTestData('Polls').getValue('Answer2', GlobalVariable.i)
	String optionC = findTestData('Polls').getValue('Answer3', GlobalVariable.i)
	
	CustomKeywords.'insideTrack.Discussions.setPollTitleandDetail'(pollName, pollDescription)
	CustomKeywords.'insideTrack.Discussions.setOptionsForPolls'(optionA, optionB, optionC)
	CustomKeywords.'insideTrack.Content.setVisibility'(privateGroup)
	CustomKeywords.'insideTrack.Content.setCategories'(categoryName)
	CustomKeywords.'insideTrack.Discussions.discussionClickPreviewandPost'()
	CustomKeywords.'insideTrack.Discussions.verifyPollSuccess'()
	WebUI.refresh()

}