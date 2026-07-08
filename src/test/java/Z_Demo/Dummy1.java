package Z_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObj.SignUpObj;

public class Dummy1 {

	
	 private static final By FIRSTNAME_XPATH = By.xpath("//input[@id='firstname']");
	    private static final By LASTNAME_XPATH = By.xpath("//input[@id='lastname']");
	    private static final By EMAIL_XPATH = By.xpath("//input[@id='email']");
	    private static final By PASSWORD_XPATH = By.xpath("//input[@id='password']");
	    private static final By CONFIRM_PASSWORD_XPATH = By.xpath("//input[@id='confirm_password']");
	    private static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[@type='submit' or contains(., 'Submit')]");
	    private static final By GOOGLE_SSO_XPATH = By.xpath("//*[contains(text(), 'Google SSO')]");
	    private static final By LOGIN_BUTTON_XPATH = By.xpath("//button[contains(., 'Log In') or span[text()='Log In']]");
	    public static WebDriver driver;	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();

		
		
		
		

	}
	
	 public void enterSingleField(String firstName, String lastName, String email, String password, String confirmPassword) {
		 SignUpObj signupPage = new SignUpObj(driver);   
		 driver.findElement(FIRSTNAME_XPATH).sendKeys(firstName);
//	        driver.findElement(LASTNAME_XPATH).sendKeys(lastName);
//	        driver.findElement(EMAIL_XPATH).sendKeys(email);
//	        driver.findElement(PASSWORD_XPATH).sendKeys(password);
//	        driver.findElement(CONFIRM_PASSWORD_XPATH).sendKeys(confirmPassword);
	    }

}
