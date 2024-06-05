package com.parentcomn.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Propertiess {

	static Properties properties = new Properties();
	WebDriver driver=new ChromeDriver();


	public static void main(String[] args) {
		String fileName = "D:\\All bot Documents\\parentcomunication.Properties"; // Replace this with your file path
		try (InputStream input = new FileInputStream(fileName);
				InputStreamReader reader = new InputStreamReader(input, "UTF-8")) {
			properties.load(reader);
			System.out.println(propertiesFile()); // This will print the value of the "welcome_message" key
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String propertiesFile() {
		String welcomeMessage = properties.getProperty("ST001");
		return welcomeMessage;
	}
	
}
