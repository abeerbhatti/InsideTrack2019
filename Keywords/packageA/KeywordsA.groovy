package packageA
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


class KeywordsA {
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)

	@Keyword
	def loginUptimeAdmin(){
		WebUI.openBrowser('https://uptime-test.wisegateit.com/member/login/auth')
		String username = findTestData('Admin').getValue('Username', 2)
		String password = findTestData('Admin').getValue('Password', 2)
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	@Keyword
	def loginUptimeGeneralUser(){
		String username = 'abeer.bhatti+sabraitis@conradlabs.com'
		String password = 'w1seg@te'
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	@Keyword
	def loginWisegateAdmin(){
		String username = findTestData('Admin').getValue('Username', 1)
		String password = findTestData('Admin').getValue('Password', 1)
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	@Keyword
	def visibility(){
		driver.findElement(By.cssSelector("div[class='resource-visibility'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		String privateGroup = findTestData('Resource').getValue('privateGroup', 1)
		driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='" + privateGroup + "']")).click()
	}

	@Keyword
	def categories(){
		driver.findElement(By.cssSelector("div[class='resource-category'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		String categoryName = findTestData('Resource').getValue('categoryName', 1)
		driver.findElement(By.xpath("//div[@class='positionHelper']/div/ul/li[@name='"+ categoryName +"']/a/span[text()='"+ categoryName +"']")).click()
	}

	@Keyword
	def typeResource(){
		driver.findElement(By.xpath("//div[@class='suggest_on_resource']/a/span[@class='accessMenuSelection']")).click()
		WebUI.delay(1)
		String type = findTestData('Resource').getValue('Type', 1)
		driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='" + type +  "']")).click()
	}

	@Keyword
	def linkResource(){
		WebUI.check(findTestObject('ResourcePage/link/linkRadio'))
		String URL = findTestData('Resource').getValue('link', 1)
		WebUI.setText(findTestObject('ResourcePage/link/linkURLField'), URL)
		WebUI.delay(1)
		WebUI.click(findTestObject('ResourcePage/addingtheLink'))
		WebUI.delay(1)
	}

	@Keyword
	def uploadFileResource(){
		//WebUI.scrollToElement(findTestObject('ResourcePage/file/uploadBtn'), 3)
		WebUI.delay(2)
		WebUI.uploadFile(findTestObject('ResourcePage/file/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/TestImage.jpg')
		WebUI.delay(4)
	}

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}