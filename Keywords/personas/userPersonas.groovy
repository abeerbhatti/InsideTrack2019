package personas

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import internal.GlobalVariable

public class userPersonas {

	@Keyword
	def loginUptimeCommunityMgr(){
		WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
		String username = findTestData('Admin').getValue('Username', 2)
		String password = findTestData('Admin').getValue('Password', 2)
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	// Network User
	@Keyword
	def loginUptimeNetworkUser(){
		WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
		String username = 'abeer.bhatti+sabraitis@conradlabs.com'
		String password = 'w1seg@te'
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	// SomeEmails User
	@Keyword
	def loginUptimeSmallGroupUser(){
		WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
		String username = 'abeer.bhatti+PhoebeReid@conradlabs.com'
		String password = 'w1seg@te'
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	@Keyword
	def loginWisegateCommunityMgr(){
		WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
		String username = findTestData('Admin').getValue('Username', 1)
		String password = findTestData('Admin').getValue('Password', 1)
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}

	def loginUptimeExternalUser(){
		WebUI.openBrowser('https://uptime-test-new.wisegateit.com/member/login/auth')
		String username = 'abeer.bhatti+ehanselman1@conradlabs.com'
		String password = 'w1seg@te'
		WebUI.setText(findTestObject('Login/Username'), username)
		WebUI.setText(findTestObject('Login/Password'), password)
		WebUI.click(findTestObject('Login/Loginbtn'))
	}
}
