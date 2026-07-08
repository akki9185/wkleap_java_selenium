package signUp;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import PageObj.SignUpObj;
import baseClass.BaseInt;

public class ParentSignup extends BaseInt{
	
		protected SignUpObj signupPage;
	  

	    @BeforeMethod
	    public void setupSignup() throws IOException {	    	
	    	startup();
	    	signupPage = new SignUpObj(driver);
			driver.get(GetValue("cmn", "url"));	  	        
	    }		
	
	
	
	
	    @AfterMethod
	    public void aftrcls() {
	    	driver.close();
		
	    }
	


}
