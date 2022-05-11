package com.computer;

import org.testng.annotations.Test;

import com.pom.base.Base;
import com.pom.base.GlobalVariables;
import com.pom.poc.ComputerDatabaseHomePage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ComputerTest {
	WebDriver driver;
	Base base;
	ComputerDatabaseHomePage computerPage;
	//Instancias
	String name, introducedDate, discontinuedDate, company, addedMessage, newCompany, oldPC, updatedMessage;

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		base = new Base(driver);
		driver = base.setupChromeDriver();
		computerPage = new ComputerDatabaseHomePage(driver);

		// Setup data
		this.name = base.getJSONValue("Data", "name");
		this.introducedDate = base.getJSONValue("Data", "introduced");
		this.discontinuedDate = base.getJSONValue("Data", "discontinued");
		this.company = base.getJSONValue("Data", "company");
		this.addedMessage = base.getJSONValue("Data", "added_message");
		this.newCompany = base.getJSONValue("Data", "new_company");
		this.oldPC = base.getJSONValue("Data", "old_pc");
		this.updatedMessage = base.getJSONValue("Data", "updated_message");
		computerPage.setCompany(this.company);
	}

	@Test
	public void TestAdd() throws InterruptedException {
		base.launchBrowser(GlobalVariables.URL);
		computerPage.addNewComputer(name, introducedDate, discontinuedDate);
		Assert.assertEquals(addedMessage, computerPage.getResult());
	}

	@Test
	public void TestUpdate() throws InterruptedException {
		base.launchBrowser(GlobalVariables.URL);
		computerPage.updateNewComputer(oldPC);
		Assert.assertEquals(updatedMessage, computerPage.getResult());
	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}
