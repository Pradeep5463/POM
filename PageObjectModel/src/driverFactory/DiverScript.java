package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.AppUtil;
import pageActions.AddEmployeePage;
import utilities.ExcelFileUtil;

public class DiverScript extends AppUtil {
	String inputpath = "./FileInput/Employee.xlsx";
	String outputpath = "./FileOutput/EmpResults.xlsx";
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	public void startTest() throws Throwable
	{
		report = new ExtentReports("./ExtentReports/AddEmployee.html");
		//call add employee page class
		AddEmployeePage emp = PageFactory.initElements(driver, AddEmployeePage.class);
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc = xl.rowCount("EmpData");
		Reporter.log("No. of rows are::"+rc,true);
		for (int i=1;i<rc;i++)
		{
			logger = report.startTest("Validate Add Employee");
			String fname = xl.getCellData("EmpData", i, 0);
			String mname = xl.getCellData("EmpData", i, 1);
			String lname = xl.getCellData("EmpData", i, 2);
			boolean res = emp.addemployee(fname, mname, lname);
			if(res)
			{
				xl.setCellData("EmpData", i, 3, "Pass", outputpath);
				logger.log(LogStatus.PASS, "Add Employee Success");
			}
			else
			{
				xl.setCellData("EmpData", i, 3, "Fail", outputpath);
				logger.log(LogStatus.FAIL, "Add Employee Fail");
			}
				
		}
	}
}
