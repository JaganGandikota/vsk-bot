package com.parentcomn.AbtractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponents {

	WebDriver driver;
	WebDriverWait wait;

	public Abstractcomponents(WebDriver driver) {
		this.driver = driver;
	}

	public void visibilityOfElementLocated(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void visibilityOfAllElementsLocatedBy(By findby)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	
	public void visibilityOfAllElements(WebElement findby)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(findby));
	}
	
	public void invisibilityOfTheElementLocated(By findby)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}	
}
