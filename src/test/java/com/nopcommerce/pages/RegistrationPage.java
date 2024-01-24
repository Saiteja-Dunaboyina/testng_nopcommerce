package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;

public class RegistrationPage {
	
	
	private final By registerText = By.xpath("//a[text()='Register']");
	private final By genderRadioButton = By.xpath("//label[text()='Male']");
	private final By firstNameInput = By.xpath("//input[@id='FirstName']");
	private final By lastNameInput = By.xpath("//input[@id='LastName']");
	private final By dayDropdown = By.xpath("//select[@name='DateOfBirthDay']");
	private final By monthDropdown = By.xpath("//select[@name='DateOfBirthMonth']");
	private final By yearDropdown = By.xpath("//select[@name='DateOfBirthYear']");
	private final By emailInput = By.xpath("//input[@id='Email']");
	private final By companyInput = By.xpath("//input[@id='Company']");
	private final By passwordInput = By.xpath("//input[@id='Password']");
	private final By confirmPasswordInput = By.xpath("//input[@id='ConfirmPassword']");
	private final By registerButton = By.xpath("//button[@id='register-button']");
	private final By continueButton = By.xpath("//a[text()='Continue']");
	private final By errorMsg = By.xpath("//li[text()='The specified email already exists']");
	
	
	
	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void registration(String firstname,String lastname,String date,String month,String year,
			String email,String company,String password) throws Exception {
		driver.findElement(registerText).click();
		driver.findElement(genderRadioButton).click();
		driver.findElement(firstNameInput).sendKeys(firstname);
		driver.findElement(lastNameInput).sendKeys(lastname);
		Select selectDay = new Select(driver.findElement(dayDropdown));
		selectDay.selectByValue(date);
		Select selectMonth = new Select(driver.findElement(monthDropdown));
		selectMonth.selectByValue(month);
		Select selectYear = new Select(driver.findElement(yearDropdown));
		selectYear.selectByValue(year);
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(companyInput).sendKeys(company);	
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(confirmPasswordInput).sendKeys(password);
		driver.findElement(registerButton).click();
		Thread.sleep(3000);
		if(driver.findElement(errorMsg).isDisplayed()) {
			throw new SkipException("Registration is skipped");
		}
		driver.findElement(continueButton).click();
		
	}

}
