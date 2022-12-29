package reusableComponents;

import java.io.File;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsSetup {
	
	public static com.aventstack.extentreports.ExtentReports getReporter()
	{
		File file=new File(System.getProperty("user.dir")+"//reports//index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setReportName("Automation results");
		reporter.config().setDocumentTitle("Results Web");
		
		com.aventstack.extentreports.ExtentReports extent=new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Damanpreet");
		return extent;
	}

}
