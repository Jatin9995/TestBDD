package StepDefinition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM.TestAddNewCustomer;
import POM.TestLoginPOM;
import POM.TestsearchCustbyEmail;
import POM.TestsearchCustbyname;

public class TestBaseclass {
	
	
	//Base class as a parent class use hota hai step definition class k liye. Base class parent class hota hai and step definition child class hota hai
		//jo ki base class ki properties ko inhert karta hai. 
		//Base class me hum saare common commenly used variables and methods ko maintain karte hai.
		//real time me bohot sare step definition classes hote hai to usme same variables or methods use hote hai to uske liye hum base class banate hai.
		//step definition class base class ko inhert karte hai jiske liye hum extent key use karte hai. Inhert karne se saare variables and methods accessable ho jaate hai stepdefinition class me.
		//commenly used variables and methods ko child class (Stepdefinition) me ab banae ki jarurat nahi hai because ko easily access kar sakte hai stepdefinition file me kyu ki inhert kiya hai base class ko extend keyword k through.
		
	public WebDriver driver;
	public TestLoginPOM pom;
	public TestAddNewCustomer addnewcust;
	public TestsearchCustbyEmail searchcustbyemail;
	public TestsearchCustbyname searchcustomerbyname;
	public Logger log;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	public String Generaterandommailid() {
		return(RandomStringUtils.randomAlphabetic(5));
		
		
	}

	
	//we are creating a takescreenshot method here so that we can take the screenshot in Extebt report
	
	  
	public static String Screenshot(WebDriver driver) throws IOException {
		
	TakesScreenshot srcShot= ((TakesScreenshot)driver);
File srcfile = srcShot.getScreenshotAs(OutputType.FILE);
String destination = "J:\\eclipse_Jdrive\\TestBDD\\Screenshot\\myextent.png";
File destiFile=new File(destination);
FileUtils.copyFile(srcfile, destiFile);
return destination;

	}
	
	
	
	
}
