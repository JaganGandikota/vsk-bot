package com.parentcomn.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parentcomn.AbtractComponents.Abstractcomponents;

public class LoginPageObjects extends Abstractcomponents {

	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name*='phone']")
	WebElement phoneNoField;

	@FindBy(xpath = "//p[normalize-space()='Send OTP']")
	WebElement SubmitButton;

	@FindBy(css = "div[class=\"otp MuiBox-root css-0\"]")
	WebElement OtpField;

	@FindBy(xpath = "//p[normalize-space()='Confirm']")
	WebElement confirmButton;

	@FindBy(xpath = "//button[normalize-space()='Resend OTP']")
	WebElement ResendOtp;

	@FindBy(css = "div[class*=\"MuiOutlinedInput-root\"]")
	WebElement LanguageSelection;

	@FindBy(css = "p[lang]")
	List<WebElement> Languagelists;

	@FindBy(css = "div[class=\"css-1r5to7m\"]")
	WebElement continueButton;

	@FindBy(xpath = "//div[@class=\"label MuiBox-root css-77afcz single-bot__info--h3 h3\"]/descendant::p/p")
	List<WebElement> bots;

	@FindBy(xpath = "//p[text()=\"Got it\"]")
	WebElement GotItButton;


	public void phoneNumberFiled(String mobileNumber) {
		phoneNoField.click();
		phoneNoField.sendKeys(mobileNumber);
		SubmitButton.click();
	}
	public void botLangugaeSelection(String language) throws InterruptedException {
		LanguageSelection.click();
		int s = Languagelists.size();
		for (int i = 0; i <= s - 1; i++) {
			WebElement lanName = Languagelists.get(i);
			String langugaeName = lanName.getText();
			if (langugaeName.equalsIgnoreCase(language)) {
				lanName.click();
				break;
			}
		}
		continueButton.click();
	}

	public void OtpVerification(String OTP) {
		OtpField.sendKeys(OTP);
	}

	public void ResendOtp() {
		ResendOtp.click();
	}

	public void selectBot(String botName) {
		int size = bots.size();

		for (int i = 0; i <= size; i++) {
			WebElement IndividualBotElement = bots.get(i);

			String bName = IndividualBotElement.getText();
			if (bName.equalsIgnoreCase(botName)) {
				IndividualBotElement.click();
				break;
			}
		}
	}

	public void selectGotIt() {
		GotItButton.click();
	}

	public WebElement got_It_Display() {
		return GotItButton;
	}
}
