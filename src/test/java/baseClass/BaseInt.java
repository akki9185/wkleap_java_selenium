package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseInt {
	
public static WebDriver driver;
		
	
	
	public void startup() throws IOException {

		if(GetValue("cmn", "Browser").equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(GetValue("cmn", "Browser").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser name Not matched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	
	
	
	
	private static Map<String, Properties> propertyMap = new HashMap<>();
	public static Properties loadProperties(String fileName) throws IOException {
		if(propertyMap.containsKey(fileName)) {
			return propertyMap.get(fileName);
		}
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/java/properities/" + fileName + ".properties");
		prop.load(fi);
		propertyMap.put(fileName, prop);
		return prop;
	}
	
	public static String GetValue(String filename, String key) throws IOException {
		Properties propt = loadProperties(filename);
		return propt.getProperty(key).trim();
	}	
	
	
	
	public static WebElement isElementPresent(String filename, String propkey) throws IOException {
	try {
		if(propkey.contains("xpath")) {
			return driver.findElement(By.xpath(GetValue(filename, propkey)));
			}
		else if(propkey.contains("id")) {
			return driver.findElement(By.id(GetValue(filename, propkey)));
			}
		else if(propkey.contains("name")) {
			return driver.findElement(By.name(GetValue(filename, propkey)));
			}
	}
	catch (Exception e) {
		System.out.println(e);
		System.out.println("Key Or filename is Invalid....");
	}
		return null;
		
	}
	
	
	public static List<WebElement> getListElement(String filename, String propkey) throws IOException {
	try {
		if(propkey.contains("xpath")) {
			return driver.findElements(By.xpath(GetValue(filename, propkey)));
			}
		else if(propkey.contains("id")) {
			return driver.findElements(By.id(GetValue(filename, propkey)));
			}
		else if(propkey.contains("name")) {
			return driver.findElements(By.name(GetValue(filename, propkey)));
			}
	}
	catch (Exception e) {
		System.out.println(e);
		System.out.println("Key Or filename is Invalid....");
	}
		return null;
		
	}
	


}
