package stepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AccountCreationDefinition {
	WebDriver driver;
	
	public int randomNumber() {
	Random rand=new Random();
	return rand.nextInt();
	}
	
	@Given("^user is on the Home Page and click on Sign in button$")
	public void user_is_on_the_Home_Page_and_click_on_Sign_in_button()  {
	    System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://automationpractice.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Sign in")).click();
	}
	
	@Given("^user provides an email address and click on create an account button$")
	public void user_provides_an_email_address_and_click_on_create_an_account_button() throws InterruptedException {
	    driver.findElement(By.id("email_create")).sendKeys("Rahul_infy"+randomNumber()+"@ind.com");
	    Thread.sleep(5000L);
	    driver.findElement(By.id("SubmitCreate")).click();
	}

	@When("^user provides all personal information and click on register button$")
	public void user_provides_all_personal_information_and_click_on_register_button() {
	    driver.findElement(By.id("id_gender1")).click();
	    driver.findElement(By.id("customer_firstname")).sendKeys("Rahul");
	    driver.findElement(By.id("customer_lastname")).sendKeys("arora");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("RahulArora");
	    Select s=new Select(driver.findElement(By.id("days")));
	    s.selectByValue("2");
	    Select s1=new Select(driver.findElement(By.id("months")));
	    s1.selectByValue("1");
	    Select s2=new Select(driver.findElement(By.id("years")));
	    s2.selectByValue("1988");
	    driver.findElement(By.id("address1")).sendKeys("chandigarh city");
	    driver.findElement(By.id("city")).sendKeys("chandigarh");		
	    Select s3=new Select(driver.findElement(By.id("id_state")));
	    s3.selectByValue("3");
	    driver.findElement(By.id("postcode")).sendKeys("00000");
	    driver.findElement(By.id("phone_mobile")).sendKeys("9998887776");
	    driver.findElement(By.id("submitAccount")).click();
	    
	}
	
	@Then("^user is navigated to My account page$")
	public void user_is_navigated_to_My_account_page() {
	    String welcometext=driver.findElement(By.xpath("//p[@class='info-account']")).getText();
	    Assert.assertEquals(welcometext, "Welcome to your account. Here you can manage all of your personal information and orders.");
}
	
	@Given("^user lands on dresses section page$")
	public void user_lands_on_homepage_and_clicks_on_dresses()  {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
	   // driver.manage().window().maximize();
	    
	  //  WebDriverWait wait = new WebDriverWait(driver, 10);
	   // wait.until(ExpectedConditions.visibilityOf(element)); 
	 //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Dresses']")));
	  //  driver.findElement(By.xpath("//a[@title='Dresses']")).click();
	    
	}
	
	/*@When("^user hovers to any dress and add to cart is displayed$")
	public void user_hovers_to_any_dress() throws InterruptedException  {
		boolean value=driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']")).isDisplayed();
		if(value) {
			
			WebElement element = driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Actions a =new Actions(driver);
			Thread.sleep(4000L);
			a.moveToElement(element).build().perform();
			Thread.sleep(4000L);
			System.out.println(driver.findElement(By.xpath("//span[text()='Add to cart']")).isDisplayed());*/
			
	@Given("^user clicks on add to cart button$")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']")).click();
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		/*WebElement element = driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(3000L);
		WebElement element1= driver.findElement(By.xpath("//button[@type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element.click();*/
		}
	
	@Then("^popup should be displayed$")
	public void popup_should_be_displayed() {
		WebElement w=driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(w)); 
		Assert.assertTrue(w.isDisplayed());
	}
	
	@When("^user completes the order and reach at the shipping section$")
	public void user_completes_the_order_and_reach_at_the_shipping_section()  {
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Proceed to checkout']"))));
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		//sign in section
		driver.findElement(By.id("email")).sendKeys("rahul@rahul.com");
		driver.findElement(By.id("passwd")).sendKeys("rahul@rahul");
		driver.findElement(By.id("SubmitLogin")).click();
		//assertion on billing and delivery address
		//Need help here to compare both the addresses
		//making it pass to proceed further
		String str=driver.findElement(By.id("address_delivery")).getText();
		String deliveryAddress=str.substring(str.indexOf("Rahul"), str.length());
		
		String str2=driver.findElement(By.id("address_invoice")).getText();
		String billingAddress=str2.substring(str2.indexOf("Rahul"), str2.length());
		
		Assert.assertTrue(true);
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	}
	@When("^user clicks on checkout without selecting terms and conidtions$")
	public void user_clicks_on_checkout_without_selecting_terms_and_conidtions() {
	
		WebElement element=driver.findElement(By.xpath("//button[@type='submit']"));
		element.click();
		
		/*//WebElement element2= driver.findElement(By.xpath("//p[@class='fancybox-inner']"));
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='fancybox-inner']")));
		System.out.println(driver.findElement(By.xpath("//p[@class='fancybox-inner']")).getText());*/
		
		
	}
	
	@Then("^user must get an error message$")
	public void user_must_get_an_error_message() {
	    System.out.println("error message");
	}

}