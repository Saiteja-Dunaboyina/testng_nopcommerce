package com.nopcommerce.test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.MenuBar;
import com.nopcommerce.pages.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NopcommerceTest {
	private WebDriver driver;
	private RegistrationPage  registrationPage;
	private LoginPage loginPage;
	private MenuBar menuBar;
	
	@BeforeSuite
	public void getWedDriver() {
		driver = new ChromeDriver();
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		menuBar = new MenuBar(driver);
	}
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@Test(priority = 1)
	public void registrationTest() throws Exception {
		registrationPage.registration("jack", "sparrow", "20", "11","2000", "jack@gmail.com", "google", "jack@123");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		loginPage.login("jack@gmail.com", "jack@123");
		assertTrue(loginPage.isLogoutDisplayed());
		loginPage.logout();
	}
	
	@Test(priority = 3)
	public void menuBarTest() {
		loginPage.login("jack@gmail.com", "jack@123");
		List<String> elements = Arrays.asList("Computers ","Electronics ","Apparel ","Digital downloads ","Books ","Jewelry ","Gift Cards ");
		elements.forEach((element) -> {
			assertTrue(menuBar.isMenuBarElementsDisplayed(element));
		});
		loginPage.logout();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
