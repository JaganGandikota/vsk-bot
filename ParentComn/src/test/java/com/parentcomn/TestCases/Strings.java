package com.parentcomn.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Strings {
    public static void main(String[] args) {
        // Set the path to your ChromeDrive

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://example.com"); // Replace this with your webpage URL

        // Find all <p> elements
        List<WebElement> paragraphs = driver.findElements(By.xpath("//div[@class=\"label MuiBox-root css-4zw38d no-highlights body2\"]/child::div[@class=\"label__text MuiBox-root css-0\"]/descendant::p[@data-testid]"));

        // Loop through each <p> element and print its text
        for (WebElement paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }
        // Close the browser
        driver.quit();
    }
}
