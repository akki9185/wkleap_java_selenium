package signUp;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;


public class signUp extends ParentSignup{
	
	

	@Test(priority = 1)
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
	
	
	
	
	

		
		
		
		
		
	

}
