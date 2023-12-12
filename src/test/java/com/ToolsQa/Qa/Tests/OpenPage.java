package com.ToolsQa.Qa.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenPage {

	public static void main(String[] args) {
		// driver = new FirefoxDriver();
		// ChromeOptions co = new ChromeOptions();
		// co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();

	}
}
