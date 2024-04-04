package orangehrm;
import java.time.Duration;

public class Website {
	
//--Method to Launch the website
	public static void launchwebsite() {
		DriverSetup.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		DriverSetup.driver.manage().window().maximize();
		DriverSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//--Method to close the browser
	public static void closeBrowser() {
        System.out.println("Employee details Added and Edited Successfully");
        DriverSetup.driver.quit();
    }
}
