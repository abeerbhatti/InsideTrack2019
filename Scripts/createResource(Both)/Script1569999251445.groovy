import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'personas.userPersonas.loginUptimeCommunityMgr'()

WebUI.click(findTestObject('HomePage/resourcesLink'))

String resourceTitle = findTestData('Resource').getValue('resourceTitle', 1)

String resourceSummary = findTestData('Resource').getValue('resourceSummary', 1)

String type = findTestData('Resource').getValue('Type', 1)

String privateGroup = findTestData('Resource').getValue('privateGroup', 1)

String categoryName = findTestData('Resource').getValue('categoryName', 1)

String resourceType = findTestData('Resource').getValue('resourceType', 1)

System.out.println(resourceType);

