package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefinition extends Base {
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Set up method execution");
		
		readConfig=new ReadConfig();
		
		String browser=readConfig.getBrowser();
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
		
		admin=new AdminPage(driver);
		
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
		
	}
	    

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    admin.setUsername(email);
	    admin.setPassword(password);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		admin.clickOnLogin();
	    
	}

	@Then("User verify title page should be {string}")
	public void user_verify_title_page_should_be(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
		   
	}
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() {
	    
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() {

	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() {
	    
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("user click on save button")
	public void user_click_on_save_button() {
	  
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) {
	    
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	    
	}
	
	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Tear down method will execute after each scenario");
		
		if(sc.isFailed()==true) {
			
		    String filepath="C:\\BAT_21\\04Dec2023CucumberMavenProject\\Screenshot\\failedscreenshot.png";
			
			TakesScreenshot scrshot=(TakesScreenshot)driver;
			Thread.sleep(2000);
			
			File scrFile=scrshot.getScreenshotAs(OutputType.FILE);
			
			File destFile=new File("filepath");
			
			FileUtils.copyFile(scrFile, destFile);
			
			Thread.sleep(2000);
			
		}
		
	}

}
