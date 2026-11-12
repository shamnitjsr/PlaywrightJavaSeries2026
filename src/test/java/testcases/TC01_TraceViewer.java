package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TC01_TraceViewer {

	public static void main(String[] args) {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		
		context.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(false));
		
		Page page = context.newPage();
		page.navigate("http://gmail.com");
		//page.navigate("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	
		page.locator("#identifierId").type("trainer@way2automation.com");
		//page.locator("[id='identifierId']").type("trainer@way2automation.com");
		//page.type("id=identifierId", "trainer@way2automation.com", new TypeOptions().setDelay(100));
		//page.locator("[type=email]").type("trainer@way2automation.com");
		
		
		page.click("text=Next");
//		page.click("button:has-text('Next')");
//		page.locator("[type=password]").fill("sdfsdfdsf");
//		page.click("button:has-text('Next')");
		
		//System.out.println(page.locator("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span").innerText());

		// Stop tracing and export it into a zip archive.
		context.tracing().stop(new Tracing.StopOptions()
		  .setPath(Paths.get("trace.zip")));
		
		page.close();
		context.close();
		playwright.close();
		
		
	}

}
