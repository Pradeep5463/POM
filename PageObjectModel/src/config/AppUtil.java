package config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageActions.AdminLoginPage;
import pageActions.AdminLogout;

public class AppUtil {
public static WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
		login.adminlogin("Admin", "Qedge123!@#");
	}
	@AfterTest
	public void tearDown()
	{
		AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
		logout.adminlogout();
		driver.close();
	}

}
