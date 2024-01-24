package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private final By loginText = By.xpath("//a[text()='Log in']");
	private final By emailInput = By.xpath("//input[@id='Email']");
	private final By passwordInput = By.xpath("//input[@id='Password']");
	private final By loginButton = By.xpath("//button[text()='Log in']");
	private final By logoutButton = By.xpath("//a[text()='Log out']");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String email,String password) {
		driver.findElement(loginText).click();
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public boolean isLogoutDisplayed() {
		boolean element = driver.findElement(logoutButton).isDisplayed();
		return element;
	}
	
	public void logout() {
		driver.findElement(logoutButton).click();
	}
	

}
