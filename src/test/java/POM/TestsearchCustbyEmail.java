
package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestsearchCustbyEmail {

WebDriver driver;

public TestsearchCustbyEmail(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
	
@FindBy(id = "SearchEmail")
WebElement searchemailElement;

@FindBy(id = "search-customers")
WebElement searchbtnElement;

@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr")
List<WebElement> tablerowsElements;
//
//@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr[1]//td")
//List<WebElement> tablecolumnElements;

public void enterEmailadd(String email) {
	
	searchemailElement.sendKeys(email);
}
	
public void searchbtn() {
	searchbtnElement.click();
	
}

public boolean searchcustomerbyemail(String emailadd) {
	
	boolean found=false;
	
	int rowcount = tablerowsElements.size();
//	int columncount = tablecolumnElements.size();

	for(int i=1; i<=rowcount; i++) {
		
		WebElement webElement = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr[" + i + "]//td[2]"));
		String Actualmail = webElement.getText();
	
		if(Actualmail.equals(emailadd)) {
			found=true;
			
		}
	}
	return found;
	
}
	
}
