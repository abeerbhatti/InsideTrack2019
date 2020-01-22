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

//Logging in
WebUI.openBrowser('https://uptime-test.wisegateit.com/member/login/auth')
username = findTestData('Admin').getValue('Username', 2)
password = findTestData('Admin').getValue('Password', 2)
WebUI.setText(findTestObject('Login/Username'), username)
WebUI.setText(findTestObject('Login/Password'), password)
WebUI.click(findTestObject('Login/Loginbtn'))
WebUI.delay(3)
WebUI.navigateToUrl('https://uptime-test.wisegateit.com/member/announcement/list')
WebUI.delay(2)

//Defining Driver and Executor
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor executor = ((driver) as JavascriptExecutor)

WebUI.click(findTestObject('Announcements/addNewAnnouncement'))
WebUI.verifyTextPresent("Enter an Announcement", false)

WebUI.setText(findTestObject('Announcements/titleAnnouncement'), 'Announcement 3-6819')
WebUI.setText(findTestObject('Announcements/descriptionAnnouncement'), 'Announcement 3-6819 Description')

//Type Block
driver.findElement(By.xpath("//div[@class='suggest_on_announcement']/a/span[@class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='Members']")).click()

//Private Group Block
driver.findElement(By.cssSelector("div[class='visibility-selector'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='SomeEmails']")).click()

WebUI.click(findTestObject('Announcements/postBtn'))
WebUI.verifyElementPresent(findTestObject('Announcements/successMsgAnnouncement'), 2)
