package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {                        
		                                          
		this.driver=driver;
	}
	
	// Web page Elements Library
	@FindBy(how = How.ID, using = "user_login") static WebElement User_Name_Field;
	@FindBy(how = How.ID, using = "user_pass") WebElement Password_Field;
	@FindBy(how = How.ID, using = "wp-submit") WebElement LogIn_Button;

	// Methods to interact with our elements
	public void userLogIn(String userName, String password) {
		User_Name_Field.sendKeys(userName);
		Password_Field.sendKeys(password);	
		LogIn_Button.click();
}
}