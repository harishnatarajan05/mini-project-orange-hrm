package orangehrm;

import java.time.Duration;
import org.openqa.selenium.By;

public class Log {
	
	
//--To enter Login credentials		
	public static void login(String Luser,String Lpass) {
        DriverSetup.driver.findElement(By.name("username")).sendKeys(Luser);
        DriverSetup.driver.findElement(By.name("password")).sendKeys(Lpass);
        DriverSetup.driver.findElement(By.cssSelector("button[type='submit']")).click();
        DriverSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	
	
//--Logout from the profile
	public static void logout() {
//------click on profile
		DriverSetup.driver.findElement(By.className("oxd-userdropdown-img")).click();
//------click on Logout
		DriverSetup.driver.findElement(By.linkText("Logout")).click();
	}
}
