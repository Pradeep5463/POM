package pageActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	//Define repository for login
	@FindBy(xpath = "//input[@name='txtUsername']")
	WebElement ObjUser;
	@FindBy(xpath = "//input[@name='txtPassword']")
	WebElement ObjPass;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement ObjLogin;
	//write method for login
	public void adminlogin(String user,String pass)
	{
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLogin.click();
	}
	

}
