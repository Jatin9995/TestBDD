package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPOM {
	WebDriver driver;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(name = "Password")
	WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(linkText = "Logout")
	WebElement logout;


	public TestLoginPOM(WebDriver driver) {

	this.driver=driver;
		PageFactory.initElements(driver, this);

}

	
public void entermailID(String emailadd) {
	
	email.clear();
	email.sendKeys(emailadd);
	
}
	
public void enterpwd(String password) {
	pwd.clear();
	pwd.sendKeys(password);
	
}

public void clicklogin() {
	loginbtn.click();
	
}

public void clickonlogout() {
	
	logout.click();
}

}
