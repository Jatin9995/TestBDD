package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import POM.TestAddNewCustomer;
import POM.TestLoginPOM;
import POM.TestsearchCustbyEmail;
import POM.TestsearchCustbyname;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDef extends TestBaseclass{
	
    @Before  // before hook executed. all method which we want to execute before each scenario will be mentioned under this method.
	public void Setup1() {
		
		System.out.println("Before hook executed-Setup1 method");
		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome119\\chromedriver.exe");
		driver=new ChromeDriver();
		log=Logger.getLogger("StepDef");
		PropertyConfigurator.configure("J:\\eclipse_Jdrive\\TestBDD\\Logger_folder\\log.properties");
		log.info("Chrome Broswer Launched");
		reporter=new ExtentHtmlReporter("J:\\eclipse_Jdrive\\TestBDD\\ExtentReport\\MytestReport.html");
		reporter.config().setDocumentTitle("Extent report file");
		reporter.config().setReportName("Extent Configuration Report");//we have named the report by this
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setTimeStampFormat("dd/MM/yyyy, hh:mm:ss");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		test=reports.createTest("User Launched Chrome Broswer");
		test.log(Status.PASS, MarkupHelper.createLabel("Chrome launched successfully", ExtentColor.GREEN));
	} 
	

//    @BeforeStep // this will execute before each step of the scenario
//    public void beforestepmethod() {
//    	System.out.println("Before step method executed");
//    }

    
//    @AfterStep  //this will execute after each step of the scenario
//    public void Afterstepmethod() {
//    	System.out.println("After step method executed");
//    }
    

	@Given("User launched chrome browser")
	public void user_launched_chrome_browser() {
		
//		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome119\\chromedriver.exe");
//driver=new ChromeDriver();
driver.manage().window().maximize();

	}

	@When("user open the URL as {string}")
	public void user_open_the_url_as(String urlString) {
		driver.navigate().to(urlString);		
		
 pom=new TestLoginPOM(driver);
 addnewcust= new TestAddNewCustomer(driver);
 searchcustbyemail= new TestsearchCustbyEmail(driver);
 searchcustomerbyname=new TestsearchCustbyname(driver);
 log.info("URL Given");
test.log(Status.PASS, MarkupHelper.createLabel("URL open successfully", ExtentColor.GREEN));

		
	}

	@And("Enter Email id as {string} and password as {string}")
	public void enter_Email_id_as_and_password_as(String loginid, String password) {
		pom.entermailID(loginid);
		pom.enterpwd(password);
		log.info("Email id & Password given to the browser");
		test.log(Status.PASS, MarkupHelper.createLabel("Valid login id & Pasword entered", ExtentColor.GREEN));

	}

	@And("Click on Login button")
	public void click_on_login_button() {
		pom.clicklogin();
	    log.info("clicked on login button");
		test.log(Status.PASS, MarkupHelper.createLabel("Clicked on Login button", ExtentColor.GREEN));

	}

	@Then("Use see the home page having page title {string}")
	public void use_see_the_home_page_having_page_title(String expectedTitle) {
	   		
	if(driver.getTitle().equals(expectedTitle)) {
		
		System.out.println("Home-Page title verifid");
		test.log(Status.PASS, MarkupHelper.createLabel("Page title verified", ExtentColor.GREEN));

	}
	else {
		
		System.out.println("Home page title not verified.");
		
		log.info("Title verified");
		test.log(Status.PASS, MarkupHelper.createLabel("Page title not verified", ExtentColor.RED));

	}
	    
	}

	@When("Use click on logout button")
	public void use_click_on_logout_button() throws InterruptedException {
		
	    pom.clickonlogout();
	    Thread.sleep(3000);
	    log.info("clicked on logut buttton");
		test.log(Status.PASS, MarkupHelper.createLabel("Clicked on logout button", ExtentColor.GREEN));

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expected) {
		
		if(driver.getTitle().equals(expected)) {
			
			System.out.println("Frount page title verified");
			log.warn("title verified through log");
			test.log(Status.PASS, MarkupHelper.createLabel("Frount Page title verified", ExtentColor.GREEN));

		}
		
		else {
			
			System.out.println("Frount page title not verified.");
		
			test.log(Status.PASS, MarkupHelper.createLabel("Frount Page title not verified", ExtentColor.GREEN));

			
		}
	    
	}

//	@After //After hook executed. all method which we want to execute after each scenario will be mentioned under this method. After hook used as a Listeners
//	//which can be used to take the screenshot incase the method is failed after the execution.
//	public void Afterhook(Scenario sc) throws IOException { //we have parameterized the After hook to take the screenshot.
//		System.out.println("After hook executed-Afterhook method");
//		if(sc.isFailed()==true) {
//		     TakesScreenshot srcshot=((TakesScreenshot)driver);
//		    File src = srcshot.getScreenshotAs(OutputType.FILE);
//		    File Destination=new File("J:\\eclipse_Jdrive\\TestBDD\\Screenshot\\afterscenariohook.png");
//		    FileUtils.copyFile(src, Destination);    
//			
//		}
//		
//		
//		driver.close();
//		log.info("Broswer closed");
//	}
//	
	
	@After // this has been take to capture the screenshor in extent report
	
	public void Extentreportscreenshot(Scenario sc) throws IOException {
		
		if(sc.isFailed()==true) {
			String myscreenshot = Screenshot(driver);
			test.log(Status.FAIL, MarkupHelper.createLabel("Login Failed", ExtentColor.RED));
			test.addScreenCaptureFromPath(myscreenshot);
			reports.flush();
			
		}
		
		
		driver.close();
		log.info("Broswer closed");
		
		
	}
	
	
	
	@Then("User close the browser")
	public void user_close_the_browser() {
		
	    //driver.close();
	    
	}
	
	
//-------------------------Add New Customer-----------------------------------------------------------------------------
	
	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		addnewcust.CustomerMenu();
		Thread.sleep(2000);
		log.info("User clicked on Customer menu");
	}

	@When("click on Customer Menu Item")
	public void click_on_customer_menu_item() throws InterruptedException {
		addnewcust.CustomerMeenuItem();
		Thread.sleep(3000);
		log.info("User clicked on Customer menu item");
	}

	@When("click on Add new Customer option")
	public void click_on_add_new_customer_option() throws InterruptedException {
		addnewcust.AddNewCustomer();
		Thread.sleep(3000);
		log.info("User clicked on Add new customer");
	}

	@Then("User can view the add new ustomer page")
	public void user_can_view_the_add_new_ustomer_page() {
		String expectedtitle="Add a new customer / nopCommerce administration";
		String actualtitle=driver.getTitle();

		if(expectedtitle.equals(actualtitle)) {

			Assert.assertTrue(true);
			log.info("New page title verified");
		}

		else {

			Assert.assertTrue(false);
			log.info("New page title not verified");

		}
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		log.info("User details provided");

		
		//addnewcust.entermailid("Jatin.rout79995@gmail.com");
		addnewcust.entermailid(Generaterandommailid() + "@gmail.com");
		addnewcust.enterPassword("Password@123");
		addnewcust.enterFirstname("Jatin");
		addnewcust.enterLastname("Rout");
		addnewcust.selectGender();
		addnewcust.selectDOB("03/21/1992");
		addnewcust.enterCompanyname("Jatin & commpany");
		addnewcust.selectisTaxexempt();
		//addnewcust.SelectCustomerRole("Registered");
		addnewcust.selectManagerofVendor("Vendor 1");
		addnewcust.checkactive();
		addnewcust.admincomment("This is Jatin, admin of this POM page");
		
		
	    
	    
	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		addnewcust.Savebtn();
		
		Thread.sleep(3000);
		log.info("Clicked on save button");

	}

	@Then("user can view message {string}")
	public void user_can_view_message(String expectedmsg) {
	    
		String Bodytagtext=driver.findElement(By.tagName("Body")).getText();
		if(Bodytagtext.contains(expectedmsg)) {

			Assert.assertTrue(true);

		}

		else {

			Assert.assertTrue(false);
		}
	    
	}
	
	//----------------------Search Cust. by email......................................................
	
	@When("enter customer email id")
	public void enter_customer_email_id() throws InterruptedException {
		searchcustbyemail.enterEmailadd("victoria_victoria@nopCommerce.com");
	    
		Thread.sleep(3000);

	}

	@When("use clicked on search button")
	public void use_clicked_on_search_button() throws InterruptedException {
		searchcustbyemail.searchbtn();
		Thread.sleep(3000);

	}

	@Then("use found email in the search table")
	public void use_found_email_in_the_search_table() {

	String expectedemailid="victoria_victoria@nopCommerce.com";
	if(searchcustbyemail.searchcustomerbyemail(expectedemailid)==true) {
		
		Assert.assertTrue(true);
	}
	else {
		
		Assert.assertTrue(false);
	}
	}
	
	
	//----------------------Search Cust. by Name......................................................

	@When("User enter First name")
	public void user_enter_first_name() throws InterruptedException {
		searchcustomerbyname.Enterfirstname("Victoria");
		Thread.sleep(4000);
	}

	@When("User enter Last name")
	public void user_enter_last_name() throws InterruptedException {
	    
		searchcustomerbyname.Enterlastname("Terces");
		Thread.sleep(4000);
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
	   
		String expectedname="Victoria Terces";
		
		if(searchcustomerbyname.searchcustbyname(expectedname)==true) {
			
			
			Assert.assertTrue(true);
		}
		else {
			
		Assert.assertFalse(false);
		}
		
	}
	
	
	
	
}
