package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.LoginPage;
import page.QuickDraftPage;
import page.SideMenuNavigationPage;
import util.BrowserFactory;

@Test
public class PostingQuickDraftTest {
	static WebDriver driver;

	public void userShouldBeAbleToPostQuickDraft() throws InterruptedException {

		driver = BrowserFactory.launchBrowser();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.userLogIn("opensourcecms", "opensourcecms");

		QuickDraftPage draftpage = PageFactory.initElements(driver, QuickDraftPage.class);
		// Create new post
		draftpage.createQuickDraft("TestDraft", "This is my midterm exam assignment");
		// Validate new post created
		draftpage.isPostExist();

		SideMenuNavigationPage sidemenu = PageFactory.initElements(driver, SideMenuNavigationPage.class);

		sidemenu.navigateToPostMenu();
		sidemenu.navigateToAllPostMenu();

		// Validate new post appeared in the posts table
		List<String> postList = draftpage.getListOfPosts();

		Assert.assertTrue(isPostCreated("TestDraft", postList), "Post is not CREATED!!");
	}

	private boolean isPostCreated(String string, List<String> postList) {
		for (int i=0; i<postList.size() ; i++) {
			if(postList.get(i).contains("TestDraft")) {
				return true;		
			}
		}
		return false;
	}
@AfterTest
public void closeBrowser() {
	driver.close();
	driver.quit();
	
	
}
	}


