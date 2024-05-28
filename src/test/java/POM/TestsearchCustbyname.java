package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestsearchCustbyname {
	
WebDriver driver;
	
	public TestsearchCustbyname(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

}

	@FindBy(id = "SearchFirstName")
	WebElement txtfirstnamElement;
	
	@FindBy(id = "SearchLastName")
	WebElement txtlastnameElement;
	
	@FindBy(id = "search-customers")
	WebElement searchbtnElement;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr")
	List<WebElement> tableroWebElement;
	
	public void Enterfirstname(String Fname) {
		txtfirstnamElement.sendKeys(Fname);
		
	}
	
	public void Enterlastname(String Lname) {
		txtlastnameElement.sendKeys(Lname);
	}
	
	
	public void searchbtn() {
		searchbtnElement.click();
	}

public boolean searchcustbyname(String txtFname) {
		
		boolean found=false;
		int rowcount=tableroWebElement.size();
		
		for(int i=1; i<+rowcount; i++) {
			
			WebElement webElement=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tr[" + i + "]//td[3]"));
			String Actualname = webElement.getText();
			if(Actualname.equals(txtFname)) {
				
				found=true;
			}
			
			
		}
		return found;
		
		
	}



}