package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TC07_NonIncognitoWindowTest {

	public static void main(String[] args) throws InterruptedException {


		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\way2automation\\AppData\\Local\\Google\\Chrome\\User Data\\Default"), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));

		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("http://way2automation.com");
		System.out.println(page.title());
		
		page.navigate("http://google.com");
		page.goBack(new GoBackOptions().setTimeout(500));
		Thread.sleep(1000);
		page.goForward(new GoForwardOptions().setTimeout(500));
		Thread.sleep(1000);
		
		page.reload();
	
		
		page.close();
		browserContext.close();
		
		playwright.close();
	
	}

}
