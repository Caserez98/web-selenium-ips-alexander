package com.pom.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pom.base.Base;

public class ComputerDatabaseHomePage extends Base {

	public ComputerDatabaseHomePage(WebDriver driver) {
		super(driver);
	}
	//Objects
	By btnAdd = By.id("add");
	By txtAlert = By.className("alert-message");
	By txtSearch = By.xpath("//input[@id='searchbox']");
	By btnSubmit = By.xpath("//input[@id='searchsubmit']");
	By txtName = By.id("name");
	By txtIntroduced = By.id("introduced");
	By txtDiscontinued = By.id("discontinued");
	By cboCompany = By.id("company");
	By btnCreate = By.xpath("//*[@id=\"main\"]/form/div/input");
	By lnkComputer = By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a");
	
	//Method to add a new Computer
	public void addNewComputer(String name, String introducedDate, String discontinuedDate) throws InterruptedException {
		waitForElementPresent(btnAdd);
		click(btnAdd);
		waitForElementPresent(btnCreate);
		type(txtName, name);
		type(txtIntroduced, introducedDate);
		type(txtDiscontinued, discontinuedDate);
		select(cboCompany);
		click(btnCreate);
		waitForElementPresent(txtAlert);
		setResult(txtAlert);
		takeScreenshot("AfterAddNewPC");

	}

	
	
	//Method to update a Computer
	public void updateNewComputer(String pc) {
		waitForElementPresent(txtSearch);
		type(txtSearch, pc);
		click(btnSubmit);
		click(lnkComputer);
		select(cboCompany);
		click(btnCreate);
		waitForElementPresent(txtAlert);
		setResult(txtAlert);
		takeScreenshot("AfterUpdatedPC");
		
	}
}
