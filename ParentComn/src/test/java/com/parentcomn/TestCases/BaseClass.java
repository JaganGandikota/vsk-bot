package com.parentcomn.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;

	// Browser launch
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://web.convegenius.ai/otp-verification");
	}

	// CAPTURE SCREENHSOT

	public String captureScreenshot(String TestName) throws IOException {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String file = System.getProperty("user.dir") + "//Screenshots//" + TestName + ".png";
		FileUtils.copyFile(screenshotFile, new File(file));
		return System.getProperty("user.dir") + "//Screenshots//" + TestName + ".png";
	}

	// EXTENT REPORT
	public static ExtentReports extentReport() {

		String path = System.getProperty("user.dir") + "//reports//index1.html";
		ExtentSparkReporter resource = new ExtentSparkReporter(path);
		resource.config().setReportName("Web Automation Test Results");
		resource.config().setDocumentTitle("Test Results");
		ExtentReports report = new ExtentReports();
		report.attachReporter(resource);
		report.setSystemInfo("Tester", "JaganGandikota");
		return report;
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
