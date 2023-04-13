package saucedemo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class chart
{
	String itemName
	String actionCart
	String itemObject

	@Keyword
	def addToChart(actionCart, itemName, itemObject)
	{
		if (actionCart == 'Detail')
		{
			new saucedemo.item().viewItemDetail(itemName)
			WebUI.click(objId(itemObject))
		}
		else if (actionCart == 'Inventory')
		{
			WebUI.click(objId(itemObject))
		}
		else
		{
			multiChart()
		}
	}

	def objId(itemObject)
	{
		def itemObjectTest = new TestObject('Object Repository/Inventory Page/button_add_to_chart')
		itemObjectTest.addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'add-to-cart-"+itemObject+"']", true)
	}

	def multiChart()
	{
		TestObject testObject = findTestObject('Object Repository/Inventory Page/button_add_to_chart')
		List<WebElement> itemLists = WebUiCommonHelper.findWebElements(testObject, 10)

		for (int i = 0; i < itemLists.size(); ++i)
		{
			WebUI.click(testObject)
		}
	}
}
