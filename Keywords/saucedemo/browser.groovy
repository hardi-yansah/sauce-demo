package saucedemo

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class browser
{

	@Keyword
	def launchBrowser()
	{
		try
		{
			KeywordUtil.logInfo("Open Browser and navigate to url")
			WebUI.openBrowser("")
			WebUI.maximizeWindow()
		} catch (Exception e)
		{
			e.printStackTrace()
			e.getMessage()
			System.exit(0)
		}
	}

	@Keyword
	def navigateUrl()
	{
		try
		{
			WebUI.navigateToUrl(GlobalVariable.url)
			KeywordUtil.markPassed("Open Browser and navigate succesfully")
			WebUI.takeScreenshot()
		} catch (Exception e)
		{
			e.printStackTrace()
			e.getMessage()
			System.exit(0)
		}
	}
}
