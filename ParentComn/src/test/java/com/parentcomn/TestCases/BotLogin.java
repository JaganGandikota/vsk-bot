package com.parentcomn.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.parentcomn.PageObjects.LoginPageObjects;

public class BotLogin extends BaseClass {

	public LoginPageObjects lp;

	By tab = By.xpath("//div[@class=\"navbar__element navbar__element--active MuiBox-root css-0\"]");
	By chatScreen = By.xpath("//div[@class=\"chat-screen css-hiazq0\"]");
	By verificationText = By.xpath("//h1[normalize-space()='Verification code']");
	By gotItButton = By.xpath("//p[text()=\"Got it\"]");

	// Login to The Bot
	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		lp = new LoginPageObjects(driver);
		lp.phoneNumberFiled("7036112276");
		Thread.sleep(25);
		lp.botLangugaeSelection("English");
		// Assert.assertTrue(driver.findElement(tab).isDisplayed());
	}

	// Bot selection
	@Test(priority = 2)
	public void botSelection() {
		lp.selectBot("जिज्ञासा");
	}

	// Click got it button
	@Test(priority = 3)
	public void select_Got_It() throws InterruptedException {

		while (lp.got_It_Display().isDisplayed()) {
			Thread.sleep(10);
			lp.selectGotIt();
		}

	}

}
