package saucedemo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class login
{

	String username
	String password

	@Keyword
	def performLogin(username, password)
	{

		def listUsername = ["standard_user", "locked_out_user", "problem_user", "performance_glitch_user"]
		Boolean assertUser =  listUsername.contains(username)
		Boolean checkPass = password == "secret_sauce"

		KeywordUtil.logInfo("Input Username")
		WebUI.sendKeys(findTestObject('Object Repository/Login Page/input_username'), username)

		KeywordUtil.logInfo("Input Password")
		WebUI.sendKeys(findTestObject('Object Repository/Login Page/input_password'), password)

		KeywordUtil.logInfo("Click Login")
		WebUI.click(findTestObject('Object Repository/Login Page/button_login'), FailureHandling.CONTINUE_ON_FAILURE)

		if (username == "")
		{
			KeywordUtil.logInfo("Verify alert username is present")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/alert_username'), 2)
			KeywordUtil.markPassed("Verify username blank not allowed")
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Login Page/alert_close'))
		} else if (password == "")
		{
			KeywordUtil.logInfo("Verify alert password is present")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/alert_password'), 2)
			KeywordUtil.markPassed("Verify username blank not allowed")
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Login Page/alert_close'))
		} else if (username == "" && password == "")
		{
			KeywordUtil.logInfo("Verify alert username is present")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/alert_username'), 2)
			KeywordUtil.markPassed("Verify username blank not allowed")
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Login Page/alert_close'))
		}else if(!assertUser && !checkPass)
		{
			KeywordUtil.logInfo("Verify alert username is present")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/alert_invalid_user'), 2)
			KeywordUtil.markPassed("Verify invalid username not allowed")
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Login Page/alert_close'))
		} else if (username == "locked_out_user")
		{
			KeywordUtil.logInfo("Verify alert username is present")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/alert_locked_user'), 2)
			KeywordUtil.markPassed("Verify username locked out not allowed login")
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Login Page/alert_close'))
		} else if (username && password)
		{
			KeywordUtil.markPassed("Login has been succesfully")
			WebUI.verifyElementVisible(findTestObject('Object Repository/Inventory Page/title_product'))
			WebUI.takeScreenshot()
		}
	}
}

