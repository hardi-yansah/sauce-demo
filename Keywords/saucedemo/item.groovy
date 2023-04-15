package saucedemo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class item
{

	String itemName

	@Keyword
	def viewItemDetail (itemName)
	{
		KeywordUtil.logInfo("Click item name")
		WebUI.scrollToElement(objText(itemName), 2)
		WebUI.click(objText(itemName))

		WebUI.takeScreenshot()

		KeywordUtil.logInfo('Verify the item name')
		WebUI.verifyElementVisible(findTestObject('Object Repository/Inventory Page/obj_details_product_name'))

		KeywordUtil.logInfo('Verify the item description')
		WebUI.verifyElementVisible(findTestObject('Object Repository/Inventory Page/obj_details_desc'))

		KeywordUtil.logInfo('Verify the item price')
		WebUI.verifyElementVisible(findTestObject('Object Repository/Inventory Page/obj_details_price'))
	}
	
	def objText(itemName)
	{
		def itemObjectTest = new TestObject('Object Repository/Inventory Page/obj_product_name')
		itemObjectTest.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = '"+itemName+"' or . = '"+itemName+"')]", true)
	}
}
