package orangehrm;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Employee {

//------Clicking on PIM tab
	public static void pim() {
		DriverSetup.driver.findElement(By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/pim/viewPimModule']")).click();
		DriverSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
		
//--addEmployee method is called to add a new employee details to the Database
	public static void addEmployee(String fname,String mname,String lname,String uname,String pass,String cpass) throws InterruptedException
	{
		DriverSetup.driver.findElement(By.linkText("Add Employee")).click();
		DriverSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//------Entering First, middle and last name
		DriverSetup.driver.findElement(By.name("firstName")).sendKeys(fname);
		DriverSetup.driver.findElement(By.name("middleName")).sendKeys(mname);
		DriverSetup.driver.findElement(By.name("lastName")).sendKeys(lname);
		
//------To click login details slider and create new login details
		DriverSetup.driver.findElement(By.cssSelector("span.oxd-switch-input")).click();
		DriverSetup.driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(uname);
		DriverSetup.driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active' and @type='password'])[1]")).sendKeys(pass);
		DriverSetup.driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys(cpass);
		DriverSetup.driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
	}
	
//--Click on "Employee list" and search for the added member
	public static void goToEmployeeList() throws InterruptedException
	{
//------click on employee list
		DriverSetup.driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")).click();
//------select the added member
		DriverSetup.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Harish Natarajan T");
		DriverSetup.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
		Thread.sleep(2000);
		DriverSetup.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]/i")).click();
		Thread.sleep(3000);
	}
	
	
//--Edit employee details
	public static void editEmployee() throws IOException
	{
		
//------Edit Nationality		
		DriverSetup.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]")).click();
		List<WebElement> list = DriverSetup.driver.findElements(By.className("oxd-select-option"));
			for(WebElement a : list)
			{
				if(a.getText().contains("Indian"))
				{
					a.click();
					break;
				}
			}
			
//------Edit Martial status
		WebDriverWait wait = new WebDriverWait(DriverSetup.driver,Duration.ofSeconds(10));
		WebElement ab=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")));
		ab.click();
		List<WebElement> lis = DriverSetup.driver.findElements(By.className("oxd-select-option"));
			for(WebElement b : lis)
			{
				if(b.getText().contains("Single"))
				{
					b.click();
					break;
				}
			}	
			
//------Select 'gender' radio button
		DriverSetup.driver.findElement(By.xpath("//label[text()='Male']")).click();
			
//-----Taking Screen shot
		File scrnsht=((TakesScreenshot) DriverSetup.driver).getScreenshotAs(OutputType.FILE);
		
//-----Saving the Screen shot
		File scr=new File("./screenshot/snap.png");
		FileHandler.copy(scrnsht, scr);

//-----save button
		DriverSetup.driver.findElement(By.xpath("(//div[@class='oxd-form-actions']/button)[1]")).click();

	}
}
