package org.mvn;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class AdactinLogin extends BaseClass {
	@BeforeClass
	public static void browserLaunch() {
		launchUrl("http://www.adactin.com/HotelApp/");
	}
	@Test
	public void loginPage() throws IOException, InterruptedException {
		LoginPage a=new LoginPage();
		enterText(a.getUsername(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 0));
	    enterText(a.getPassword(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 1));
	    btnClick(a.getLogin());
	    SearchHotel s=new SearchHotel();
	    selectionByIndex(s.getLocation(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 2)));
	    selectionByIndex(s.getHotel(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 3)));
	    selectionByIndex(s.getRoomtype(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 4)));
	    selectionByIndex(s.getNumberofRooms(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 5)));
	    selectionByIndex(s.getAdults(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 6)));
	    selectionByIndex(s.getChildren(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 0, 7)));
	    btnClick(s.getSearch());
	    SelectHotel h=new SelectHotel();
	    btnClick(h.getRadiobutton());
	    btnClick(h.getCntbutton());
	    BookHotel b=new BookHotel();
	    Thread.sleep(6000);
	    enterText(b.getFirstname(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 0));
	    enterText(b.getLastname(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 1));
	    enterText(b.getAddress(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 2));
	    enterText(b.getCreditcard(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 3));
	    selectionByIndex(b.getCardtype(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 4)));
	    selectionByIndex(b.getExpmonth(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 5)));
	    selectionByIndex(b.getExpyear(), Integer.parseInt(excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 6)));
	    enterText(b.getCvv(), excelRead("D:\\class record\\Readdata.xlsx", "abcd", 1, 7));
	    btnClick(b.getBooknow());
	    BookingConfirmation c=new BookingConfirmation();
	    Thread.sleep(6000);
	    String ordernumber = gettingAttribute(c.getOrdernumber(), "value");
	    excelWrite("D:\\class record\\sheet1.xlsx", "abcde", 0, 0, ordernumber);
	    }
	
	@Before
	public void verify() {
		Date d=new Date();
		System.out.println(d);
	}
	@After
	public  void verifyAfter() {
		Date d1=new Date();
		System.out.println(d1);	
	}
	@AfterClass
	public static void closeDriver() {
		driver.quit();
		}
	}


