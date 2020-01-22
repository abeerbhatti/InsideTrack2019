import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


WebUI.openBrowser('https://www.w3schools.com/tags/tag_thead.asp')
WebUI.maximizeWindow()
WebDriver driver = DriverFactory.getWebDriver()
String ExpectedValue = 'Opera'

WebElement Table = driver.findElement(By.xpath("//table[@class='browserref notranslate']/tbody"))
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
int rows_count = rows_table.size()

Loop:
for (int row = 0; row < rows_count; row++){
	List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('th'))
	int columns_count = Columns_row.size()
	
	println((('Number of cells In Row ' + row) + ' are ') + columns_count)
	
	for(int columns = 0; columns < columns_count; columns++){
		String celltext = Columns_row.get(columns).getText()
		
		println((((('Cell Value Of row number ' + row) + ' and column number ') + columns) + ' Is ') + celltext)
		
		if (celltext == ExpectedValue){
			println('Text present is' + Columns_row.get(2).getText() + 'the value is' + celltext)
			
			break Loop
		}
		
	}
	
	
}