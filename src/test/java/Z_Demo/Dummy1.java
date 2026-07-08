package Z_Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
	
	
	public static void main(String[] args) throws IOException {
		
		
	
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		SignUpObj signupPage = new SignUpObj(driver);
		driver.get("https://staging.wkleap.com/signup");
		driver.manage().window().maximize();
		
		
		
		String path = "/home/user/Desktop/TestData.xlsx";
		// FIX 1: You must instantiate the formatter object here!
        DataFormatter formatter = new DataFormatter();
		
		
		try (FileInputStream fis = new FileInputStream(path);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            // Get the first sheet
	            Sheet sheet = workbook.getSheet("Sheet2");
	            int totalColumns = sheet.getRow(0).getLastCellNum();
	            
	            
	            
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {	
	            	driver.navigate().refresh();
	        		Row row = sheet.getRow(i);
//	                System.out.println(row.getCell(i));
	                if (row == null) {
	                    System.out.println(); // Skip empty rows gracefully
	                    continue;
	                }
	                
	                for (int j = 0; j < totalColumns; j++) {
	                    // CREATE_NULL_AS_BLANK prevents NullPointerException on empty cells
	                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    
	                    // Print cell value aligned nicely
	                    System.out.printf("%-18s", cell.toString());                      
	                }
	                System.out.println();
					String fname = formatter.formatCellValue(row.getCell(0));
					String lname = formatter.formatCellValue(row.getCell(1));
					String email = formatter.formatCellValue(row.getCell(2));
					String password = formatter.formatCellValue(row.getCell(3));
					String conf_pass = formatter.formatCellValue(row.getCell(4));
                    
//                    signupPage.clickSubmit();
//        	        String firstNameMsg = signupPage.getFirstNameValidationMessage();
//        	        Assert.assertNotNull(firstNameMsg, "First Name validation message is null");
//        	        Assert.assertFalse(firstNameMsg.isEmpty(), "First Name validation message should not be empty");
//
//                    
//                    
//        	        signupPage.enterFirstName(fname);
//        	        signupPage.enterLastName(lname);
//        	        signupPage.enterEmail(email);
//        	        signupPage.enterPassword(password);
//        	        signupPage.enterConfirmPassword(conf_pass); 
					
					// 1. Submit blank form and verify First Name validation message
					signupPage.clickSubmit();
					String firstNameMsg = signupPage.getFirstNameValidationMessage();
					Assert.assertNotNull(firstNameMsg, "First Name validation message is null");
					Assert.assertFalse(firstNameMsg.isEmpty(), "First Name validation message should not be empty");

					// Fill First Name
					signupPage.enterFirstName(fname);

					// Only proceed to check Last Name validation if fname was not empty
					if (!fname.isEmpty()) {
						// 2. Submit and verify Last Name validation message
						signupPage.clickSubmit();
						String lastNameMsg = signupPage.getLastNameValidationMessage();
						Assert.assertNotNull(lastNameMsg, "Last Name validation message is null");
						Assert.assertFalse(lastNameMsg.isEmpty(), "Last Name validation message should not be empty");

						// Fill Last Name
						signupPage.enterLastName(lname);

						// Only proceed to check Email validation if lname was not empty
						if (!lname.isEmpty()) {
							// 3. Submit and verify Email validation message
							signupPage.clickSubmit();
							String emailMsg = signupPage.getEmailValidationMessage();
							Assert.assertNotNull(emailMsg, "Email validation message is null");
							Assert.assertFalse(emailMsg.isEmpty(), "Email validation message should not be empty");

							// Fill Email
							signupPage.enterEmail(email);

							// Check if email format is valid
							signupPage.clickSubmit();
							String emailFormatMsg = signupPage.getEmailValidationMessage();
							if (emailFormatMsg != null && !emailFormatMsg.isEmpty()) {
								// Email format is invalid (e.g. missing "@" or domain)
								System.out.println("Email format validation triggered successfully for: " + email);
							} else {
								// Email format is valid, proceed to verify Password validation
								if (!email.isEmpty()) {
									String passwordMsg = signupPage.getPasswordValidationMessage();
									Assert.assertNotNull(passwordMsg, "Password validation message is null");
									Assert.assertFalse(passwordMsg.isEmpty(), "Password validation message should not be empty");

									// Fill Password
									signupPage.enterPassword(password);

									// Only proceed to check Confirm Password validation if password was not empty
									if (!password.isEmpty()) {
										// 5. Submit and verify Confirm Password validation message
										signupPage.clickSubmit();
										String confirmPasswordMsg = signupPage.getConfirmPasswordValidationMessage();
										Assert.assertNotNull(confirmPasswordMsg, "Confirm Password validation message is null");
										Assert.assertFalse(confirmPasswordMsg.isEmpty(), "Confirm Password validation message should not be empty");

										// Fill Confirm Password
										signupPage.enterConfirmPassword(conf_pass);

										// Only check matching validation if conf_pass is not empty
										if (!conf_pass.isEmpty()) {
											// Verify that Confirm Password matches Password
											signupPage.clickSubmit();
											String mismatchMsg = signupPage.getConfirmPasswordValidationMessage();
											if (!password.equals(conf_pass)) {
												// Password mismatch does not trigger HTML5 validation error, but form remains on signup page
												Assert.assertTrue(mismatchMsg == null || mismatchMsg.isEmpty(), "Mismatch should not trigger HTML5 validation error");
												String currentUrl = driver.getCurrentUrl();
												Assert.assertTrue(currentUrl.contains("/signup"), "Should remain on the signup page");
											} else {
												// If passwords match, verify there is no error message
												Assert.assertTrue(mismatchMsg == null || mismatchMsg.isEmpty(), "There should be no validation error when passwords match");
											}
										}
									}
								}
							}
						}
					}
                    
	            }
	            
	            if (driver != null) {
	                driver.quit();
	            }
	}
		}
}
