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

// Logging in
//WebUI.openBrowser('https://uptime-test.wisegateit.com/member/login/auth')
//username = findTestData('Admin').getValue('Username', 2)
//password = findTestData('Admin').getValue('Password', 2)
//WebUI.setText(findTestObject('Login/Username'), username)
//WebUI.setText(findTestObject('Login/Password'), password)
//WebUI.click(findTestObject('Login/Loginbtn'))
//WebUI.delay(3)

//Defining Driver and Executor
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = ((driver) as JavascriptExecutor)

//Redirect to Discussions List Page
//WebUI.maximizeWindow()
//WebUI.click(findTestObject('HomePage/resourcesLink'))
WebUI.delay(5)
WebUI.click(findTestObject('ResourcePage/addResource'))
String resourceTitle = findTestData('Resource').getValue('resourceTitle', GlobalVariable.i)
WebUI.setText(findTestObject('ResourcePage/Common/resourceTitle'), resourceTitle)
//WebUI.setText(findTestObject('ResourcePage/Common/resourceTitle'), 'Resource IT5-260719')
String resourceSummary = findTestData('Resource').getValue('resourceSummary', GlobalVariable.i)
WebUI.setText(findTestObject('ResourcePage/Common/resourceSummary'), resourceSummary)
//WebUI.setText(findTestObject('ResourcePage/Common/resourceSummary'), 'Resource IT5-260719 Summary')

//Type Block
driver.findElement(By.xpath("//div[@class='suggest_on_resource']/a/span[@class='accessMenuSelection']")).click()
WebUI.delay(1)
String type = findTestData('Resource').getValue('Type', GlobalVariable.i)
driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='" + type +  "']")).click()
//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='Case Studies']")).click()

//Private Group Block
driver.findElement(By.cssSelector("div[class='resource-visibility'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
String privateGroup = findTestData('Resource').getValue('privateGroup', GlobalVariable.i)
//privateGroup = 'SomeEmails'
driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='" + privateGroup + "']")).click()

//Category Block
driver.findElement(By.cssSelector("div[class='resource-category'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
String categoryName = findTestData('Resource').getValue('categoryName', GlobalVariable.i)
//categoryName = 'Risk & Resiliency'
driver.findElement(By.xpath("//div[@class='positionHelper']/div/ul/li[@name='"+ categoryName +"']/a/span[text()='"+ categoryName +"']")).click()

WebUI.check(findTestObject('ResourcePage/link/linkRadio'))
String URL = findTestData('Resource').getValue('link', GlobalVariable.i)
WebUI.setText(findTestObject('commonObjects/linkURLField1'), URL)
//WebUI.setText(findTestObject('ResourcePage/link/linkURLField'), 'https://www.quora.com')
WebUI.delay(1)
WebUI.click(findTestObject('commonObjects/addingtheLink'))
WebUI.delay(1)
WebUI.verifyElementChecked(findTestObject('ResourcePage/Common/sendNotification'), 3)
WebUI.verifyElementChecked(findTestObject('ResourcePage/Common/uptimeLogo'), 3)
WebUI.click(findTestObject('ResourcePage/Common/continueBtn'))
WebUI.delay(1)
WebUI.click(findTestObject('ResourcePage/link/postBtn'))
WebUI.waitForElementNotVisible(findTestObject('ResourcePage/Common/postingBtn'), 120, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('ResourcePage/Common/successMsgResource'), 2)
WebUI.delay(5)
WebUI.refresh()
//WebUI.delay(10)


