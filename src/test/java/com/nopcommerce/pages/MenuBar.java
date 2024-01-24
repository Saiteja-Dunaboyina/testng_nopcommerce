package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuBar {
	
	private WebDriver driver;
	
	public MenuBar(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isMenuBarElementsDisplayed(String element) {
		boolean isDisplay =  driver.findElement(By.xpath("(//a[text()='"+element+"'])[1]")).isDisplayed();
		return isDisplay;
	}

}
