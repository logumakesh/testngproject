package org.mvn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static Actions a;
	public static void launchUrl (String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\MavenProject28\\driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get(url);
	}
	public static WebElement elementlocatorById(String id) {
		 return driver.findElement(By.id(id));
	}
	public static WebElement elementLocatorByXpath(String Xpath) {
		 return driver.findElement(By.xpath(Xpath));
    }
	public static void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public static void btnClick(WebElement element) {
		element.click();
	}
    public static  void selectionByIndex(WebElement element,int index) {
		s=new Select(element);
		s.selectByIndex(index);
   }
    public  static String gettingAttribute(WebElement element,String attname) {
	  return element.getAttribute(attname);
	   
	  
    }
    public  static void doubleClick(WebElement element) {
    	a=new Actions(driver);
		a.doubleClick(element).perform();
  }
   public static String excelRead(String pathname,String sname,int rownum,int cellnum) throws IOException {
	   File f=new File(pathname);
	   FileInputStream str=new FileInputStream(f);
	   Workbook w=new XSSFWorkbook(str);
	   Sheet sheet = w.getSheet(sname);
	   Row row = sheet.getRow(rownum);
	   Cell cell = row.getCell(cellnum);
	   int cellType = cell.getCellType();
	   String data= null;
	   if(cellType==1) {
		  data = cell.getStringCellValue();
	   }
	   else if (DateUtil.isCellDateFormatted(cell)) {
		   Date dateCellValue = cell.getDateCellValue();
		   SimpleDateFormat fo=new SimpleDateFormat("MMM/DD/YYYY");
		   data= fo.format(dateCellValue);
		}
	   else {
		double numericCellValue = cell.getNumericCellValue();
		long l=(long)numericCellValue;
		data = String.valueOf(l);
	}
return data;
}
   public static void excelWrite(String pathname,String sname,int rownum,int cellnum,String attname) throws IOException {
	File f=new File(pathname);
	Workbook w=new XSSFWorkbook();
	Sheet createSheet = w.createSheet(sname);
	Row createRow = createSheet.createRow(rownum);
	Cell createCell = createRow.createCell(cellnum);
	createCell.setCellValue(attname);
	FileOutputStream str =new FileOutputStream(f);
	w.write(str);
	
	}
   }
    
    
    
    
    
    
    
    
    
    

