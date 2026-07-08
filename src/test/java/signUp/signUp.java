package signUp;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;


public class signUp extends ParentSignup{
	
	

	@Test(priority = 1, description = "Verify all Fileds are there")
	public void case1() throws IOException, InterruptedException {
			Assert.assertTrue(signupPage.isFirstNameDisplayed(), "First Name input is not displayed");
	        Assert.assertTrue(signupPage.isLastNameDisplayed(), "Last Name input is not displayed");
	        Assert.assertTrue(signupPage.isEmailDisplayed(), "Email input is not displayed");
	        Assert.assertTrue(signupPage.isPasswordDisplayed(), "Password input is not displayed");
	        Assert.assertTrue(signupPage.isConfirmPasswordDisplayed(), "Confirm Password input is not displayed");
	        Assert.assertTrue(signupPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
	        Assert.assertTrue(signupPage.isGoogleSsoDisplayed(), "Google SSO button is not displayed");
	        Assert.assertTrue(signupPage.isLoginButtonDisplayed(), "Log In button is not displayed");
	    }
	
		@Test(priority = 2, description = "Verify sequential field validations for all form fields.")
	    public void testSequentialFieldValidation() {
	        signupPage.waitForPageLoad();

	        // 1. Submit blank form and verify First Name validation message
	        signupPage.clickSubmit();
	        String firstNameMsg = signupPage.getFirstNameValidationMessage();
	        Assert.assertNotNull(firstNameMsg, "First Name validation message is null");
	        Assert.assertFalse(firstNameMsg.isEmpty(), "First Name validation message should not be empty");

	        // Fill First Name
	        signupPage.enterFirstName("John");

	        // 2. Submit and verify Last Name validation message
	        signupPage.clickSubmit();
	        String lastNameMsg = signupPage.getLastNameValidationMessage();
	        Assert.assertNotNull(lastNameMsg, "Last Name validation message is null");
	        Assert.assertFalse(lastNameMsg.isEmpty(), "Last Name validation message should not be empty");

	        // Fill Last Name
	        signupPage.enterLastName("Doe");

	        // 3. Submit and verify Email validation message
	        signupPage.clickSubmit();
	        String emailMsg = signupPage.getEmailValidationMessage();
	        Assert.assertNotNull(emailMsg, "Email validation message is null");
	        Assert.assertFalse(emailMsg.isEmpty(), "Email validation message should not be empty");

	        // Fill Email
	        signupPage.enterEmail("john.doe@example.com");

	        // 4. Submit and verify Password validation message
	        signupPage.clickSubmit();
	        String passwordMsg = signupPage.getPasswordValidationMessage();
	        Assert.assertNotNull(passwordMsg, "Password validation message is null");
	        Assert.assertFalse(passwordMsg.isEmpty(), "Password validation message should not be empty");

	        // Fill Password
	        signupPage.enterPassword("TestPassword123!");

	        // 5. Submit and verify Confirm Password validation message
	        signupPage.clickSubmit();
	        String confirmPasswordMsg = signupPage.getConfirmPasswordValidationMessage();
	        Assert.assertNotNull(confirmPasswordMsg, "Confirm Password validation message is null");
	        Assert.assertFalse(confirmPasswordMsg.isEmpty(), "Confirm Password validation message should not be empty");

	        // Fill Confirm Password
	        signupPage.enterConfirmPassword("TestPassword123!");
	    }
	
	
	
	
	

		
		
		
		
		
	

}
