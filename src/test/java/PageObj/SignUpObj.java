package PageObj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpObj {
	
    private final WebDriver driver;
    private final WebDriverWait wait;	
	

	  // Element XPaths
	    private static final By FIRSTNAME_XPATH = By.xpath("//input[@id='firstname']");
	    private static final By LASTNAME_XPATH = By.xpath("//input[@id='lastname']");
	    private static final By EMAIL_XPATH = By.xpath("//input[@id='email']");
	    private static final By PASSWORD_XPATH = By.xpath("//input[@id='password']");
	    private static final By CONFIRM_PASSWORD_XPATH = By.xpath("//input[@id='confirm_password']");
	    private static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[@type='submit' or contains(., 'Submit')]");
	    private static final By GOOGLE_SSO_XPATH = By.xpath("//*[contains(text(), 'Google SSO')]");
	    private static final By LOGIN_BUTTON_XPATH = By.xpath("//button[contains(., 'Log In') or span[text()='Log In']]");
	    		
	    		
	   public SignUpObj(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	   
	   public void waitForPageLoad() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRSTNAME_XPATH));
	    }

	    public boolean isFirstNameDisplayed() {
	        return driver.findElement(FIRSTNAME_XPATH).isDisplayed();
	    }

	    public boolean isLastNameDisplayed() {
	        return driver.findElement(LASTNAME_XPATH).isDisplayed();
	    }

	    public boolean isEmailDisplayed() {
	        return driver.findElement(EMAIL_XPATH).isDisplayed();
	    }

	    public boolean isPasswordDisplayed() {
	        return driver.findElement(PASSWORD_XPATH).isDisplayed();
	    }

	    public boolean isConfirmPasswordDisplayed() {
	        return driver.findElement(CONFIRM_PASSWORD_XPATH).isDisplayed();
	    }

	    public boolean isSubmitButtonDisplayed() {
	        return driver.findElement(SUBMIT_BUTTON_XPATH).isDisplayed();
	    }

	    public boolean isGoogleSsoDisplayed() {
	        return driver.findElement(GOOGLE_SSO_XPATH).isDisplayed();
	    }

	    public boolean isLoginButtonDisplayed() {
	        return driver.findElement(LOGIN_BUTTON_XPATH).isDisplayed();
	    }

	    public void clickSubmit() {
	        wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON_XPATH));
	        driver.findElement(SUBMIT_BUTTON_XPATH).click();
	    }

	    public String getFirstNameValidationMessage() {
	        return driver.findElement(FIRSTNAME_XPATH).getAttribute("validationMessage");
	    }

	    public String getLastNameValidationMessage() {
	        return driver.findElement(LASTNAME_XPATH).getAttribute("validationMessage");
	    }

	    public String getEmailValidationMessage() {
	        return driver.findElement(EMAIL_XPATH).getAttribute("validationMessage");
	    }

	    public String getPasswordValidationMessage() {
	        return driver.findElement(PASSWORD_XPATH).getAttribute("validationMessage");
	    }

	    public String getConfirmPasswordValidationMessage() {
	        return driver.findElement(CONFIRM_PASSWORD_XPATH).getAttribute("validationMessage");
	    }
	    public void enterFirstName(String firstName) {
	        driver.findElement(FIRSTNAME_XPATH).sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        driver.findElement(LASTNAME_XPATH).sendKeys(lastName);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(EMAIL_XPATH).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(PASSWORD_XPATH).sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) {
	        driver.findElement(CONFIRM_PASSWORD_XPATH).sendKeys(confirmPassword);
	    }
	    
	    

	    public void enterSignupDetails(String firstName, String lastName, String email, String password, String confirmPassword) {
	        driver.findElement(FIRSTNAME_XPATH).sendKeys(firstName);
	        driver.findElement(LASTNAME_XPATH).sendKeys(lastName);
	        driver.findElement(EMAIL_XPATH).sendKeys(email);
	        driver.findElement(PASSWORD_XPATH).sendKeys(password);
	        driver.findElement(CONFIRM_PASSWORD_XPATH).sendKeys(confirmPassword);
	    }

	    public void clickLoginButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON_XPATH));
	        driver.findElement(LOGIN_BUTTON_XPATH).click();
	    }
}
