package com.pom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {
	private WebDriver driver;
	private String company;
	private Select drpCompany;
	private String result;
	/**
	 * Constructor SeleniumWrapper Class 
	 * @author alexander.lara 
	 * @param driver
	 * @return N/A
	 * @throws N/A
	 */

	public Base(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * Launch browser
	 * @author alexander.lara
	 * @param
	 * @return WebDriver
	 * @throws
	 * @date 2022/05/11
	 */
	public WebDriver setupChromeDriver() {
		 ChromeOptions chromeOpt = new ChromeOptions();
		 WebDriverManager.chromedriver().setup();		  
		 driver = new ChromeDriver(chromeOpt);
		 return driver;
	}
	/*
	 * Launch browser
	 * @author alexander.lara
	 * @param string
	 * @return
	 * @throws
	 * @date 2022/05/11
	 */
	public void launchBrowser(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	
	/*
	 * Type text into text box object
	 * @author alexander.lara
	 * @param locator
	 * @param inputText
	 * @return
	 * @throws
	 * @date 2022/05/11
	 */
	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	/*
	 * Click object
	 * @author alexander.lara
	 * @param locator
	 * @return
	 * @throws
	 * @date 2022/05/11
	 */	
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/*
	 * Set text of message in private variable
	 * @author alexander.lara
	 * @param locator
	 * @return
	 * @throws
	 * @date 2022/05/11
	 */
	public void setResult(By locator) {
		this.result=driver.findElement(locator).getText();
	}
	
	/*
	 * Return the result message
	 * @author alexander.lara
	 * @param
	 * @return String
	 * @throws
	 * @date 2022/05/11
	 */
	public String getResult() {
		return this.result;
	}
	
	/*
	 * Select object in drop-down menu.
	 * @author alexander.lara
	 * @param locator
	 * @return
	 * @throws
	 * @date 2022/05/11
	 */
	public void select(By locator) {
		this.drpCompany = new Select(driver.findElement(locator));
		this.drpCompany.selectByVisibleText(this.getCompany());
	}
	
	
	/*
	 * Return company name
	 * @author alexander.lara
	 * @param
	 * @return String
	 * @throws
	 * @date 2022/05/11
	 */
	public String getCompany() {
		return this.company;
	}
	
	/*
	 * Set the company name
	 * @author alexander.lara
	 * @param String
	 * @return 
	 * @throws
	 * @date 2022/05/11
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/*
	 * Driver close
	 * @author alexander.lara
	 * @param
	 * @return
	 * @throws
	 * @date
	 */
	public void closeBrowser() {
		driver.close();
	}
	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author alexander.lara
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	/*
	 * Take screenshot
	 * 
	 * @author alexander.lara
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	/**
	 * Implicity Wait
	 * 
	 * @author alexander.lara
	 */
	public void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch(TimeoutException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Wait For Element Present (Explicit wait)
	 * 
	 * @author alexander.lara
	 * @param locator
	 * @return
	 * @throws TimeoutException
	 */
	public void waitForElementPresent(By locator) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
}
