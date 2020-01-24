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

WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')

CustomKeywords.'personas.userPersonas.loginUptimeCommunityMgr'()

WebUI.scrollToElement(findTestObject('contactMemberServices/memberServicesLink'), 3)
WebUI.click(findTestObject('contactMemberServices/memberServicesLink'))
WebUI.verifyTextPresent("We'd like to hear from you!", false)
WebUI.verifyTextPresent("Or, call Member Services at (240) 200-3987", false)

WebUI.setText(findTestObject('contactMemberServices/subject'), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum consequat rutrum. Nam porta volutpat enim, sed hendrerit lorem blandit nec.')
WebUI.setText(findTestObject('contactMemberServices/message'), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum consequat rutrum. Nam porta volutpat enim, sed hendrerit lorem blandit nec. Nam blandit a elit dignissim faucibus. Donec iaculis arcu a nulla placerat viverra. Vestibulum mollis, justo sit amet sagittis rutrum, sapien metus iaculis ex, vel egestas ex mauris quis velit. Cras vestibulum nunc a est pharetra maximus at a nisl. Morbi euismod lectus quis eros maximus, non molestie magna fermentum. Aliquam et massa ligula. Nullam tellus lorem, rhoncus sit amet est vitae, sodales pretium lorem. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis a enim id ex hendrerit egestas. Suspendisse in fringilla elit.')
WebUI.click(findTestObject('contactMemberServices/sendBtn'))
WebUI.verifyElementPresent(findTestObject('contactMemberServices/successFeedback'), 2)
