package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class TC03_TestFrames {

	public static void main(String[] args) {

	
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		String href = (String) page.evaluate("document.location.href");
		System.out.println(href);
		
		
		
		page.frameLocator("[name='iframeResult']").locator("body > button").click(new ClickOptions().setTimeout(2000));
		page.frameLocator("[name='iframeResult']").locator("body > button").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot_element.png")));
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
		
		//page.frameLocator("[name='iframeResult']").locator("body > button").evaluate("() => arguments[0].style.border='3px solid red'");
		
		Locator frames = page.locator("iframe");
		
		System.out.println(frames.count());
		
		
		
		for(int i=0; i<frames.count(); i++) {
			
			System.out.println(frames.nth(i).getAttribute("id"));
			
		}
		
		
		
		page.close();
		playwright.close();
		browser.close();
		
		

	}

}
