 package utilities;
 
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

//import testBase.BaseClass;

public class Extend_Report_Manager implements ITestListener{
	
      public ExtentSparkReporter sparkReporter;  // UI of the report
      public ExtentReports extent;  //populate common info on the report
      public ExtentTest test;  //creating test case entries in the report and update of the test methods

      String repName;
      
      public void onStart(ITestContext testContext) {
    	  
			/*
			 * SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt =
			 * new Date(); String currentdatetimestamp = df.format(df);
			 */
    	  
    	  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	  
    	  repName = "Test-Report-" + timeStamp + ".html";
    	  
    	  sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);   ////Specific Location of the report
    	  
    	  sparkReporter.config().setDocumentTitle("opencart Automation Report");  //Title of the report
    	  sparkReporter.config().setReportName("opencart Functional Testing");  // name of the report
    	  sparkReporter.config().setTheme(Theme.DARK);
    	  
    	  extent = new ExtentReports();
    	  extent.attachReporter(sparkReporter);
    	  
    	  extent.setSystemInfo("Application", "opencart");
    	  extent.setSystemInfo("Module", "Admin");
    	  extent.setSystemInfo("Sub Module", "Customers");
    	  extent.setSystemInfo("User Name", System.getProperty("user.name"));
    	  extent.setSystemInfo("Environment", "QA");
    	  
    	  String os = testContext.getCurrentXmlTest().getParameter("os");
    	  extent.setSystemInfo("Operating System", os);
    	  
    	  String browser = testContext.getCurrentXmlTest().getParameter("browser");
    	  extent.setSystemInfo("Browser", browser);
    	  
    	  List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
    	  if(!includeGroups.isEmpty()) {
    		  extent.setSystemInfo("Groups", includeGroups.toString());
    	  }
      }
      
      public void onTestSuccess(ITestResult result) {
    	  
    	  test = extent .createTest(result.getTestClass().getName());  //Create a new enty in the report
    	  test.assignCategory(result.getMethod().getGroups()); //to display groups in reports
    	  test.log(Status.PASS, result.getName() + "Got Successfully executed"); //update status p/f/s
    	  
      }
      
      public void onTestFailure(ITestResult result) {
    	  
    	  test = extent .createTest(result.getTestClass().getName());   //Create a new enty in the report
    	  test.assignCategory(result.getMethod().getGroups());
    	  
    	  test.log(Status.FAIL, result.getName() + "Test case got FAILED"); 
    	  test.log(Status.INFO, result.getThrowable().getMessage());
    	  
    	  String imgPath = new BaseClass().captureScreen(result.getName());
		  test.addScreenCaptureFromPath(imgPath);
      }
    
     public void onTestSkipped(ITestResult result) {
    	  
    	  test = extent .createTest(result.getTestClass().getName());//Create a new enty in the report
    	  test.assignCategory(result.getMethod().getGroups());
    	  
    	  test.log(Status.SKIP, result.getName() +  "Test case got SKIPPED "); //update status p/f/s
    	  
    	  test.log(Status.INFO, result.getThrowable().getMessage());
      }
     public void onFinish(ITestContext context) {
    	 extent.flush();
    	 
    	 String pathOfExtentReport = System.getProperty("user.dir") + ".\\reports\\" + repName;
    	 File extentReport = new File(pathOfExtentReport);
    	 
    	
    		 try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    	 }
    	 
     }
 
   
 
 


 
 
 
 
 