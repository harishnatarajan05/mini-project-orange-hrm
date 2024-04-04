package orangehrm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	public static WebDriver driver = null;
	
//Selection of browser (chrome/edge)
    public static WebDriver getWebDriver(String driverStr) {
//If Chrome browser is selected
        if(driverStr.equalsIgnoreCase("chrome")) {
            System.out.println("Chrome Browser is selected");
            driver=new ChromeDriver();
        }
//If Edge browser is selected
        else if(driverStr.equalsIgnoreCase("edge")) {
            System.out.println("Edge Browser is selected");
            driver = new EdgeDriver();
        }
        return driver;
    }
}
