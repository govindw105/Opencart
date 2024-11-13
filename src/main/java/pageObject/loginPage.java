package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}
