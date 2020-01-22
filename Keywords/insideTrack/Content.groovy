package insideTrack

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

public class Content{

	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)

	@Keyword
	def setVisibility(String privateGroup){
		driver.findElement(By.cssSelector("div[class='resource-visibility'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		List <WebElement> visibility = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: visibility) {
			if(privateGroup.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='" + privateGroup + "']")).click()
	}

	@Keyword
	def setCategories(String categoryName){
		driver.findElement(By.cssSelector("div[class='resource-category'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		List <WebElement> category = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li[class='cfm']"))
		for (WebElement option: category) {
			if(categoryName.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.xpath("//div[@class='positionHelper']/div/ul/li[@name='"+ categoryName +"']/a/span[text()='"+ categoryName +"']")).click()
	}

	@Keyword
	def uploadFile(){
		//WebUI.scrollToElement(findTestObject('ResourcePage/file/uploadBtn'), 3)
		WebUI.delay(4)
		WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/fnd-agile-syllabus_ga.pdf')
		WebUI.delay(4)
	}

	@Keyword
	def addLink(){
		WebUI.check(findTestObject('ResourcePage/link/linkRadio'))
		String URL = findTestData('Resource').getValue('link', 2)
		WebUI.setText(findTestObject('commonObjects/linkURLField1'), URL)
		WebUI.delay(1)
		WebUI.click(findTestObject('commonObjects/addingtheLink'))
		WebUI.delay(1)
	}
}

public class Dashboard{

	@Keyword
	def verifyQuestionSuccess(){
		WebUI.verifyElementPresent(findTestObject('DiscussionsPage/Questions/successMsgQuestion'), 2)
		WebUI.delay(1)
		WebUI.click(findTestObject('DiscussionsPage/Questions/crossSuccessMsg'))
	}
}

public class Discussions{

	@Keyword
	def redirecttoQuestion(){
		WebUI.click(findTestObject('HomePage/discussionsLink'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DiscussionsPage/Questions/continueBtn'))
	}

	@Keyword
	def redirecttoPoll(){
		WebUI.click(findTestObject('HomePage/discussionsLink'))
		WebUI.delay(2)
		WebUI.check(findTestObject('DiscussionsPage/Polls/radioPoll'))
		WebUI.click(findTestObject('DiscussionsPage/Questions/continueBtn'))
	}

	@Keyword
	def landatDiscussionsListPage(){
		WebUI.click(findTestObject('HomePage/discussionsLink'))
		WebUI.delay(2)
	}

	@Keyword
	def addQuestion(){
		WebUI.click(findTestObject('DiscussionsPage/Questions/continueBtn'))
	}

	@Keyword
	def addPoll(){
		WebUI.check(findTestObject('DiscussionsPage/Polls/radioPoll'))
		WebUI.click(findTestObject('DiscussionsPage/Questions/continueBtn'))
	}

	//Set Question Title and Details
	@Keyword
	def setQuestionTitleandDetail(questionName, questionDescription){
		WebUI.setText(findTestObject('DiscussionsPage/Questions/questionName'), questionName)
		WebUI.setText(findTestObject('DiscussionsPage/Questions/questionDescription'), questionDescription)
	}

	//Set Question Title and Details
	@Keyword
	def setPollTitleandDetail(pollName, pollDescription){
		WebUI.setText(findTestObject('DiscussionsPage/Polls/pollName'), pollName)
		WebUI.setText(findTestObject('DiscussionsPage/Polls/pollDescription'), pollDescription)
	}

	//Used for Both Question and Polls Posting
	@Keyword
	def discussionClickPreviewandPost(){
		WebUI.click(findTestObject('DiscussionsPage/Common/previewBtn'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DiscussionsPage/Common/Postbtn'))
		WebUI.delay(2)
		WebUI.waitForElementNotVisible(findTestObject('DiscussionsPage/Common/Savingbtn'), 120, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def setOptionsForPolls(String optionA, optionB, optionC){
		WebUI.setText(findTestObject('DiscussionsPage/Polls/answer1Poll'), optionA)
		WebUI.setText(findTestObject('DiscussionsPage/Polls/answer2Poll'), optionB)
		WebUI.setText(findTestObject('DiscussionsPage/Polls/answer3Poll'), optionC)
	}

	@Keyword
	def verifyQuestionSuccess(){
		WebUI.verifyElementPresent(findTestObject('DiscussionsPage/Questions/successMsgQuestion'), 2)
		WebUI.delay(1)
		WebUI.click(findTestObject('DiscussionsPage/Questions/crossSuccessMsg'))
		WebUI.refresh()
		WebUI.delay(2)
	}

	@Keyword
	def verifyPollSuccess(){
		WebUI.verifyElementPresent(findTestObject('DiscussionsPage/Polls/successMsgPoll'), 2)
		WebUI.click(findTestObject('DiscussionsPage/Polls/crossSuccessMsg'))
		WebUI.delay(5)
	}
}

public class Resources{

	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)

	@Keyword
	def redirecttoResource(){
		WebUI.click(findTestObject('HomePage/resourcesLink'))
		WebUI.delay(2)
		WebUI.click(findTestObject('ResourcePage/addResource'))
	}

	@Keyword
	def setResourceTitleandDetail(resourceTitle, resourceSummary){
		WebUI.setText(findTestObject('ResourcePage/Common/resourceTitle'), resourceTitle)
		WebUI.setText(findTestObject('ResourcePage/Common/resourceSummary'), resourceSummary)
	}

	@Keyword
	def typeResource(type){
		driver.findElement(By.xpath("//div[@class='suggest_on_resource']/a/span[@class='accessMenuSelection'][contains(text(), 'Select Type')]")).click()
		WebUI.delay(2)
		List <WebElement> resourcetype = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: resourcetype)
		{
			if(type.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='" + type +  "']")).click()
	}

	@Keyword
	def checkboxesVerification(){
		WebUI.verifyElementChecked(findTestObject('ResourcePage/Common/sendNotification'), 3)
		WebUI.verifyElementChecked(findTestObject('ResourcePage/Common/uptimeLogo'), 3)
	}

	@Keyword
	def verifyResourceSuccess(){
		WebUI.click(findTestObject('ResourcePage/Common/continueBtn'))
		WebUI.delay(1)
		WebUI.click(findTestObject('ResourcePage/file/postBtn'))
		WebUI.waitForElementNotVisible(findTestObject('ResourcePage/Common/postingBtn'), 120, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('ResourcePage/Common/successMsgResource'), 2)
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(5)
	}
}

public class Announcement{

	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)

	@Keyword
	def landAtAnnouncementListPage(){
		WebUI.navigateToUrl('https://uptime-test-new.wisegateit.com/member/announcement/list')
	}

	@Keyword
	def addAnnouncement(){
		WebUI.click(findTestObject('Announcements/addNewAnnouncement'))
		WebUI.verifyTextPresent("Enter an Announcement", false)
	}

	@Keyword
	def redirecttoAnnouncement(){
		WebUI.navigateToUrl('https://uptime-test.wisegateit.com/member/announcement/list')
		WebUI.click(findTestObject('Announcements/addNewAnnouncement'))
		WebUI.verifyTextPresent("Enter an Announcement", false)
	}

	@Keyword
	def setAnnouncementTitleandDescription(announcementtitle, announcementDescription){
		WebUI.setText(findTestObject('Announcements/titleAnnouncement'), announcementtitle)
		WebUI.setText(findTestObject('Announcements/descriptionAnnouncement'), announcementDescription)
	}

	@Keyword
	def setAnnouncementRegion(region){
		driver.findElement(By.xpath("//div[@class='suggest_on_announcement']/a/span[@class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		List <WebElement> announcementregion = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul > li"))
		for (WebElement option: announcementregion)
		{
			if(region.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='Russia']")).click()
	}

	@Keyword
	def setAnnouncementType(type){
		driver.findElement(By.xpath("(//div[@class='suggest_on_announcement']/a/span[@class='ui-icon ui-icon-triangle-1-s'])[2]")).click()
		WebUI.delay(1)
		List <WebElement> announcementtype = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul > li"))
		for (WebElement option: announcementtype)
		{
			if(type.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='"+ type +"']")).click()
	}

	@Keyword
	def setAnnouncementVisibility(privateGroup){
		driver.findElement(By.cssSelector("div[class='visibility-selector'] > div > div > a > span[class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		List <WebElement> visibility = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: visibility)
		{
			if(privateGroup.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='"+ privateGroup +"']")).click()
	}

	@Keyword
	def postAnnouncement(){
		WebUI.click(findTestObject('Announcements/postBtn'))
	}

	@Keyword
	def verifyAnnouncementSuccess(){
		WebUI.verifyElementPresent(findTestObject('Announcements/successMsgAnnouncement'), 2)
	}
}

public class Events{

	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)

	@Keyword
	def redirectToEvents(){
		WebUI.click(findTestObject('Events/eventsLink'))
		WebUI.click(findTestObject('Events/Upcoming/addUpcomingEvent'))
		WebUI.verifyTextPresent("Post an Upcoming Event", false)
	}

	@Keyword
	def redirectToEventWrapUp(){
		WebUI.click(findTestObject('Events/WrapUps/eventWrapUptab'))
		WebUI.click(findTestObject('Events/WrapUps/addEventWrapUp'))
		WebUI.verifyTextPresent("Post an Event Wrap-up", false)
	}

	@Keyword
	def setEventTitleDescLocReglink(eventTitle, eventDescription, location, registerationLink){
		WebUI.verifyTextPresent("Post an Upcoming Event", false)
		WebUI.setText(findTestObject('Events/Upcoming/titleUpcomingEvent'), eventTitle)
		WebUI.setText(findTestObject('Events/Upcoming/descriptionUpcomingEvent'), eventDescription)
		WebUI.setText(findTestObject('Events/Upcoming/location'), location)
		WebUI.setText(findTestObject('Events/Upcoming/registrationLink'), registerationLink)
	}

	@Keyword
	def setEventWrapUpTitleDescLoc(eventTitle, eventDescription, location){
		WebUI.setText(findTestObject('Events/Upcoming/titleUpcomingEvent'), eventTitle)
		WebUI.setText(findTestObject('Events/Upcoming/descriptionUpcomingEvent'), eventDescription)
		WebUI.setText(findTestObject('Events/Upcoming/location'), location)
	}

	@Keyword
	def setEventTime(eventTime){
		WebUI.executeJavaScript("prefillDate('event.dateTime','"+ eventTime +"')", null)
	}

	@Keyword
	def selectSendAnnouncementNow(){
		WebUI.check(findTestObject('Events/Upcoming/sendAnnouncementNow'))
		//WebUI.verifyElementPresent(findTestObject('Events/Upcoming/sendAnnouncementNow'), 20)
	}

	@Keyword
	def selectAllDayMultiDay(){
		//WebUI.verifyElementChecked(findTestObject('Events/Upcoming/allDayMultiDay'), 3)
		WebUI.selectOptionByValue(findTestObject('Events/Upcoming/durationInDays'), '3', false)
	}

	@Keyword
	def selectSameDayEvent(){
		WebUI.click(findTestObject('Events/Upcoming/allDayMultiDay'))
		WebUI.verifyElementNotChecked(findTestObject('Events/Upcoming/allDayMultiDay'), 3)
		WebUI.setText(findTestObject('Events/Upcoming/durationInMinutes'), '60')
		WebUI.verifyElementPresent(findTestObject('Events/Upcoming/durationInMinutes'), 20)
	}

	@Keyword
	def attachFiles(){
		WebUI.check(findTestObject('Events/Upcoming/attachFileCheckbox'))
		WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/fnd-agile-syllabus_ga.pdf')
		WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/Focus-Failure.pdf')
		WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/CloudSlides2017_18.pdf')
		WebUI.uploadFile(findTestObject('commonObjects/fileUploadBtnCSS'), '/Users/abeerbhatti/Downloads/Survey2018 - 12.pdf')
	}

	@Keyword
	def sharedLink(){
		WebUI.check(findTestObject('Events/Upcoming/shareLinkCheckbox'))
		WebUI.setText(findTestObject('commonObjects/linkURLField1'), 'www.quora.com')
		WebUI.click(findTestObject('commonObjects/addingtheLink2'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Events/Upcoming/addMorelinks'))
		WebUI.setText(findTestObject('commonObjects/linkURLField2'), 'www.google.com')
		WebUI.click(findTestObject('commonObjects/addingtheLink2'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Events/Upcoming/addMorelinks'))
		WebUI.setText(findTestObject('commonObjects/linkURLField3'), 'www.youtube.com')
		WebUI.click(findTestObject('commonObjects/addingtheLink2'))
		WebUI.delay(8)
	}

	@Keyword
	def setEventType(type){
		driver.findElement(By.xpath("//div[@class='suggest_on_event']/a/span[@class='accessMenuSelection'][contains(text(), 'Select Type')]")).click()
		WebUI.delay(1)
		List <WebElement> eventtype = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: eventtype)
		{
			if(type.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='"+ type +"']")).click()
	}

	@Keyword
	def setEventVisibility(privateGroup){
		driver.findElement(By.xpath("//div[@class='suggest_on_event']/a/span[@class='accessmenuSelection'][contains(text(), 'Select Visibility')]")).click()
		WebUI.delay(1)
		List <WebElement> eventpg = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: eventpg)
		{
			if(privateGroup.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='" + privateGroup + "']")).click()
	}

	@Keyword
	def setEventCategory(categoryName){
		driver.findElement(By.xpath("//div[@class='suggest_on_event']/a/span[@class='menuSelection'][contains(text(), 'Select a Category')]")).click()
		WebUI.delay(1)
		List <WebElement> eventcat = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li"))
		for (WebElement option: eventcat)
		{
			if(categoryName.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul[class='fg-menu ui-corner-all'] > li > a[name='"+ categoryName +"']")).click()
	}

	@Keyword
	def setEventRegion(region){
		driver.findElement(By.xpath("//div[@class='suggest_on_event']/a/span[@class='ui-icon ui-icon-triangle-1-s']")).click()
		WebUI.delay(1)
		List <WebElement> eventreg = driver.findElements(By.cssSelector("div[class='positionHelper'] > div > ul > li"))
		for (WebElement option: eventreg)
		{
			if(region.equals(option.getText()))
				option.click();
		}
		//driver.findElement(By.cssSelector("div[class='positionHelper'] > div > ul > li > a[name='"+ region +"']")).click()
	}

	@Keyword
	def postVerifyEventSuccess(){
		WebUI.click(findTestObject('Events/Upcoming/postBtn'))
		WebUI.verifyElementPresent(findTestObject('Events/Upcoming/successMsgEvents'), 40)
	}
}
