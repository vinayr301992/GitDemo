package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.php.util.TestUtil;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"/Reports/PHPTravels+"+TestUtil.getCurrentDataTime()+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vinay");
		return extent;
		
	}
}
