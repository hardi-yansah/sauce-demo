package saucedemo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class logout
{
	@Keyword
	def doLogout()
	{
		WebUI.comment("Logout")
		WebUI.click(findTestObject('Object Repository/Menu/obj_menu'))
		WebUI.click(findTestObject('Object Repository/Menu/a_logout'))
	}
}
