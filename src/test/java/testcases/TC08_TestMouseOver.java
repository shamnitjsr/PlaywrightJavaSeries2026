package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC08_TestMouseOver {

	public static void main(String[] args) {


		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.way2automation.com/");

		
		page.locator("//*[@id=\"menu-item-27580\"]/a/span[2]").hover();
		page.locator("//*[@id=\"menu-item-27592\"]/a").click();
	

	}

}
