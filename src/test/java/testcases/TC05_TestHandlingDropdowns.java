package testcases;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class TC05_TestHandlingDropdowns {

	public static void main(String[] args) {



		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.wikipedia.org/");
		
		//select by value
		page.selectOption("select", "hi");
		
	
		//select by text
		page.selectOption("select", new SelectOption().setLabel("Eesti"));

		
		//select by index
		page.selectOption("select", new SelectOption().setIndex(1));
		
		/*
		Locator values = page.locator("select > option");
		System.out.println(values.count());
		
		
		for(int i=0; i<values.count(); i++) {
			
			System.out.println(values.nth(i).innerText()+"----"+values.nth(i).getAttribute("lang"));
			
			
		}*/
		
		
		
		List<ElementHandle> values = page.querySelectorAll("select > option");
		
		System.out.println(values.size());
		
		
		for(ElementHandle value: values) {
			
			System.out.println(value.innerText()+"----"+value.getAttribute("lang"));
			
			
		}
		
		
		page.close();
		playwright.close();
		
		
	}

}
