package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestAddNewCustomer {

	WebDriver driver;
	
	public TestAddNewCustomer(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerMenuElement;
	
	@FindBy(xpath = "//a[contains(@href,'/Admin/Customer/List')]//p[contains(text(),'Customers')]")
	WebElement customermenuItemElement;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addNeWebElement;
	
	@FindBy(id = "Email")
	WebElement txtemailelElement;
	
	@FindBy(id="Password")
	WebElement txtpassElement;
	
	@FindBy(name = "FirstName")
	WebElement txtFirstnamElement;
	
	@FindBy(name = "LastName")
    WebElement txtLastNamElement;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement selectGenbderElement;
	
	@FindBy(name = "DateOfBirth")
	WebElement selectDOBElement;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companynamElement;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement taxElement;
	
	@FindBy(xpath = "//input[@class='select2-search__field valid']")
	WebElement customerroleElement;
	
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement selectvendoridElement;
	
	@FindBy(xpath = "//input[@id='Active']")
	WebElement checkActiveboxElement;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement adcomment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	
////////////////////////////////Methods for Add New Customer web elements  /////////////////////////////////////////////////

public void CustomerMenu() {
	customerMenuElement.click();
	
}
	
public void CustomerMeenuItem() {
	customermenuItemElement.click();
}
	
public void AddNewCustomer() {
	addNeWebElement.click();
	
}

public void entermailid(String email) {
	txtemailelElement.sendKeys(email);
	
}

public void enterPassword(String pwd) {
	txtpassElement.sendKeys(pwd);
}


public void enterFirstname(String firstname) {
	txtFirstnamElement.sendKeys(firstname);
}

public void enterLastname(String lastname) {
	txtLastNamElement.sendKeys(lastname);
}

public void selectGender() {
	selectGenbderElement.click();
}


public void selectDOB(String DOB) {
	
	selectDOBElement.sendKeys(DOB);
}
	
public void enterCompanyname(String company) {
	
	companynamElement.sendKeys(company);
}

public void selectisTaxexempt() {
	taxElement.click();
}


public void SelectCustomerRole() {
	

	customerroleElement.sendKeys("Registered");
}

public void selectManagerofVendor(String value2) {
	
	Select dropdown=new Select(selectvendoridElement);
	dropdown.selectByVisibleText(value2);
}

public void checkactive() {
	checkActiveboxElement.click();
}

public void admincomment(String comment) {
	adcomment.sendKeys(comment);


}

public void Savebtn() {
	savebtn.click();
}



}