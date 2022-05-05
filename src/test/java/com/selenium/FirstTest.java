package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
  @Test
  public void setup() {
	  	ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);

		driver.get("https://computer-database.gatling.io/computers");
		driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("ACE");
		driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
		String textElement = driver.findElement(By.xpath("/html/body/section/table/tbody/tr[1]/td[1]/a")).getText();
		System.out.println(textElement);
		
		
		////*[@id="main"]/div[1]/strong
}
 @Test
 public void add() {
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);
		driver.get("https://computer-database.gatling.io/computers");
		
		driver.findElement(By.xpath("/html/body/section/div[1]/form/a")).click();
		driver.findElement(By.xpath("/html/body/section/form/fieldset/div[1]/div/input")).sendKeys("Test");
		driver.findElement(By.xpath("/html/body/section/form/fieldset/div[2]/div/input")).sendKeys("2020-05-20");
		driver.findElement(By.xpath("/html/body/section/form/fieldset/div[3]/div/input")).sendKeys("2022-05-20");
		Select drpCompany = new Select(driver.findElement(By.name("company")));
		drpCompany.selectByVisibleText("RCA");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();
		
		String textResult = driver.findElement(By.className("alert-message")).getText();
		
		Assert.assertEquals("Done ! Computer Test has been created", textResult);
		System.out.println(textResult);


 }
 @Test
 public void update() {
	 ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);
		driver.get("https://computer-database.gatling.io/computers");
		driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("ASCI Thors Hammer");
		driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a")).click();
		Select drpCompany = new Select(driver.findElement(By.name("company")));
		drpCompany.selectByVisibleText("Apple Inc.");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();
		String textResult = driver.findElement(By.className("alert-message")).getText();
		
		Assert.assertEquals("Done ! Computer ASCI Thors Hammer has been updated", textResult);
		System.out.println(textResult);
		

 }	
 
}
