package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmployeePage {
	WebDriver driver;
	public AddEmployeePage(WebDriver driver)
	{
		this.driver = driver;
	}
	//define repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickPIM;
	@FindBy(name = "btnAdd")
	WebElement clickAdd;
	@FindBy(name = "firstName")
	WebElement EnterFname;
	@FindBy(name = "middleName")
	WebElement EnterMname;
	@FindBy(name = "lastName")
	WebElement EnterLname;
	@FindBy(name = "employeeId")
	WebElement BeforeEID;
	@FindBy(id = "btnSave")
	WebElement ClickSave;
	@FindBy(name = "personal[txtEmployeeId]")
	WebElement AfterEID;
	//method for employee
	public boolean addemployee(String Firstname,String Middlename,String Lastname)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.clickPIM).click().perform();
		ac.moveToElement(this.clickAdd).click().perform();
		this.EnterFname.sendKeys(Firstname);
		this.EnterMname.sendKeys(Middlename);
		this.EnterLname.sendKeys(Lastname);
		//capture eid
		String Exp_EID = this.BeforeEID.getAttribute("value");
		ac.moveToElement(this.ClickSave).click().perform();
		//capture eid
		String Act_EID = this.AfterEID.getAttribute("Value");
		if (Exp_EID.equals(Act_EID))
		{
			Reporter.log("Add Employee Success"+Exp_EID+"  "+Act_EID,true);
			return true;
		}
		else
		{
			Reporter.log("Add Employee Fail"+Exp_EID+"  "+Act_EID,true);
		    return false;
		}
	}
	

}
