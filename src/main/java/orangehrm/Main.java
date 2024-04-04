package orangehrm;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	public static void main(String[] args) {
		boolean bol = true;
//------Getting input from user to select the browser
		System.out.println("Enter the browser to Automate (Chrome/Edge)");
		while(bol)
		{
			Scanner sc = new Scanner(System.in);
			String Browser = sc.next();
			if(Browser.equalsIgnoreCase("Chrome") || (Browser.equalsIgnoreCase("Edge"))){
				DriverSetup.getWebDriver(Browser);
				bol =false;
				sc.close();
			}
			else 
			{
				System.out.println("Enter Valid Browser name(Chrome/Edge)");		
			}	
		}
		

//Getting input details from the excel sheet
		try {
		File excelFile=new File("./Input-details.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workBook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workBook.getSheetAt(0);
//------Login credentials
		XSSFRow r1=sheet.getRow(1);
		XSSFCell c1=r1.getCell(0);
		XSSFCell c2=r1.getCell(1);
//------Details for 'Add employee'
		XSSFRow r11=sheet.getRow(1);
		XSSFCell c11=r11.getCell(2);
		XSSFCell c21=r11.getCell(3);
		XSSFCell c31=r11.getCell(4);
		XSSFCell c41=r11.getCell(5);
		XSSFCell c51=r11.getCell(6);
		XSSFCell c61=r11.getCell(7);
		workBook.close();

//------saving login credentials in string variables
		String Luser=c1.toString();
		String Lpass=c2.toString();
//------Saving other details in string variables
		String fname=c11.toString();
		String mname=c21.toString();
		String lname=c31.toString();
		String uname=c41.toString();
		String pass=c51.toString();
		String cpass=c61.toString();
		
//Calling methods from different classes
		
//------Launching website
		Website.launchwebsite();
//------Login
		Log.login(Luser, Lpass);
//------Clicking PIM tab
		Employee.pim();		
//------Add Employee tab
		Employee.addEmployee(fname, mname, lname, uname, pass, cpass);
//------Editing added employee details
		Employee.goToEmployeeList();
		Employee.editEmployee();
//------Logout from the website
		Log.logout();
//------Closing the browser
		Website.closeBrowser();
		}
//Exception handling
		catch(Exception e ) 
		{
			e.printStackTrace();
		}
	}
}
