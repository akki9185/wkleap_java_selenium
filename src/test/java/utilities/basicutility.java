package utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObj.SignUpObj;
import baseClass.BaseInt;



public class basicutility extends BaseInt {
	
	
	public static WebElement waitForElementClickable(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(Element));
		}
	
	
	public void assertBalnkFielsValidation() {
			SignUpObj signupPage = new SignUpObj(driver);		
			String validationMessage = signupPage.getFirstNameValidationMessage();
	        Assert.assertNotNull(validationMessage, "Validation message attribute is missing");
	        Assert.assertFalse(validationMessage.isEmpty(), "No validation message shown for empty First Name");
	
}
	

}
