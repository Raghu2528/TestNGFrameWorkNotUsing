package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ApplicationLibrary.GenericMethods;
import dao.PropertiesFileReader;

public class DataSourceCreationTestCases {
	static WebDriver driver;
	@Parameters ({"browser"})
	@BeforeTest
	public void openBrowserAndLogin(String browser) throws InterruptedException, IOException {
		GenericMethods.openBrowser("http://172.16.0.43:8080/home/#/login",browser);
		Thread.sleep(5000);
		GenericMethods.enterText(ObjectProperties.LoginPageElements.username, "raghu");
		GenericMethods.enterText(ObjectProperties.LoginPageElements.password, "raghu@123");
		GenericMethods.buttonClick(ObjectProperties.LoginPageElements.loginBtn);
		Thread.sleep(5000);
	}

@Test(priority=0)
public static void createSqlServerDatasource() throws InterruptedException {
	Thread.sleep(5000);
	GenericMethods.buttonClick(ObjectProperties.HomePageElements.connectLink);
	Thread.sleep(5000);
	GenericMethods.buttonClick(ObjectProperties.HomePageElements.createDsLink);
	Thread.sleep(5000);
	GenericMethods.verifyText(ObjectProperties.CreateDatasouce.createDsPageTitle, "Create Data Connection");
	GenericMethods.createDs("SQLServer");
	GenericMethods.dataSourceDetails("sqlserver_0000", "ggk-wrl-exp-002.ggktech.local", "1433", "saa", "Welcome@456");
	GenericMethods.datasourceSavePopups();
}




	@AfterTest
	public static void quitBrowser() {
		driver.close();
		
	}
}
