package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuickDraftPage {
	static WebDriver driver;

	public QuickDraftPage(WebDriver driver) {

		this.driver = driver;
	}

	// Web page Elements Library
	@FindBy(how = How.ID, using = "title")
	static WebElement Title_Field;
	@FindBy(how = How.ID, using = "content")
	WebElement Content_Field;
	@FindBy(how = How.ID, using = "save-post")
	WebElement Save_Button;

	// Methods to interact with our elements
	public void createQuickDraft(String title, String content) {
		Title_Field.sendKeys(title);
		Content_Field.sendKeys(content); ////
		Save_Button.click();
	}

	// Validate Post is exist using IsDisplayed
	public static void isPostExist() {
		boolean postDisplayed = driver.findElement(By.xpath("//a[contains (text(), 'TestDraft')]")).isDisplayed();

		if (postDisplayed) {
			System.out.println("Post has been saved Successfuly");
		} else {
			System.out.println("Post has not saved!!");
		}
	}

	public List<String> getListOfPosts() {
		// Get all the elements of that specific column
		List<WebElement> postTableElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		// Get the text of elements on that specific column
		List<String> postTableText = new ArrayList<String>();
		for (int i = 0; i < postTableElement.size(); i++) {
			postTableText.add(i, postTableElement.get(i).getText());
		}
		return postTableText;
	}
}
