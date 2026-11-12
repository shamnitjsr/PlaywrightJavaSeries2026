package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class TestProperties {

	public static void main(String[] args) throws IOException {


		Logger log = Logger.getLogger(TestProperties.class);
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\locators.properties");
		prop.load(fis);
		log.info("Locator properties file loaded");
		
		System.out.println(prop.get("browser"));
		log.info("Chrome browser launched");
		//popup.locator(prop.get("username_XPATH")).click();
		System.out.println(prop.get("username_XPATH"));
		log.info("entering username as trainer@way2automation.com");
		log.info("test execution completed");
		
	}

}
