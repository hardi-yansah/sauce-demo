package saucedemo
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class sorting
{
	@Keyword
	def listSorting(String filter)
	{
		TestObject nameProducts = findTestObject('Object Repository/Inventory Page/obj_product_name')
		List<WebElement> elementProducts = WebUI.findWebElements(nameProducts, 10)
		for (int i = 0; i < elementProducts.size(); ++i)
		{
			String listProducts = [
				elementProducts.get(i).getText()
			].sort()
			println(listProducts)
		}
	}
}