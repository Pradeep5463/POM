package pageActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
	//define repository for logout
	@FindBy(xpath = "//a[@class='panelTrigger']")
	WebElement ObjWelcome;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement ObjLogout;
	//Method for Logout
	public void adminlogout()
	{
	 ObjWelcome.click();
	 ObjLogout.click();
	}

}
