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

//// Logging in
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
//WebUI.click(findTestObject('HomePage/discussionsLink'))
//WebUI.delay(2)

WebUI.check(findTestObject('DiscussionsPage/Polls/radioPoll'))
WebUI.click(findTestObject('DiscussionsPage/Questions/continueBtn'))

String pollName = findTestData('Polls').getValue('poll', GlobalVariable.i)
WebUI.setText(findTestObject('DiscussionsPage/Polls/pollName'), pollName)

String pollDescription = findTestData('Polls').getValue('pollDescription', GlobalVariable.i)
WebUI.setText(findTestObject('DiscussionsPage/Polls/pollDescription'), pollDescription)

String optionA = findTestData('Polls').getValue('Answer1', GlobalVariable.i)
WebUI.setText(findTestObject('DiscussionsPage/Polls/answer1Poll'), optionA)

String optionB = findTestData('Polls').getValue('Answer2', GlobalVariable.i)
WebUI.setText(findTestObject('DiscussionsPage/Polls/answer2Poll'), optionB)

String optionC = findTestData('Polls').getValue('Answer3', GlobalVariable.i)
WebUI.setText(findTestObject('DiscussionsPage/Polls/answer3Poll'), optionC)

driver.findElement(By.cssSelector("div[class='resource-visibility'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
String privateGroup = findTestData('Polls').getValue('privateGroup', GlobalVariable.i)
driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='" + privateGroup + "']")).click()

driver.findElement(By.cssSelector("div[class='resource-category'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
WebUI.delay(1)
String categoryName = findTestData('Polls').getValue('categoryName', GlobalVariable.i)
driver.findElement(By.xpath("//div[@class='positionHelper']/div/ul/li[@name='"+ categoryName +"']/a/span[text()='"+ categoryName +"']")).click()

WebUI.click(findTestObject('DiscussionsPage/Common/previewBtn'))
WebUI.delay(2)
WebUI.click(findTestObject('DiscussionsPage/Common/Postbtn'))
WebUI.delay(2)
WebUI.waitForElementNotVisible(findTestObject('DiscussionsPage/Common/Savingbtn'), 120, FailureHandling.CONTINUE_ON_FAILURE)

////WebUI.verifyElementPresent(driver.findElement(By.xpath("//div[@class='center jGrowl']/div/div[@class='jGrowl-message'][contains(text(), 'Successfully posted your poll in the "+ categoryName +" category. ')]")), 5)
WebUI.verifyElementPresent(findTestObject('DiscussionsPage/Polls/successMsgPoll'), 2)
WebUI.click(findTestObject('DiscussionsPage/Polls/crossSuccessMsg'))
WebUI.delay(5)
WebUI.refresh()

//WebUI.click(findTestObject('DiscussionsPage/object'))
// was trying to parametrize the value that's being passed for usage in the css selector or xpath.
// in case of using an object, will have to use the xpath bajaye css selector