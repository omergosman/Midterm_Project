package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideMenuNavigationPage {

	static WebDriver driver;

	public SideMenuNavigationPage(WebDriver driver) {

		this.driver = driver;
	}

	// continue from looking for the post menu xpath
	// Web page Elements Library
	@FindBy(how = How.XPATH, using = "//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")
	static WebElement Post_Menu;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'All Posts')]")
	static WebElement AllPost_Menu;
	// @FindBy(how = How.ID, using = "save-post") WebElement Save_Button;

	// Methods to interact with our elements
	public void navigateToPostMenu() throws InterruptedException {
		Post_Menu.click();
		Thread.sleep(3000);
	}

	public void navigateToAllPostMenu() throws InterruptedException {
		AllPost_Menu.click();
		Thread.sleep(2000);
	}
}
