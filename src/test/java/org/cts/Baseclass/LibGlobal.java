package org.cts.Baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	public  static WebDriver driver;
	public static Actions acc;
	public static Select s;
	public static Alert a;
	public static JavascriptExecutor js;
	public static Robot arr;
	
	public static void browserLaunch() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	public static void ffBrowserLaunch() {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	}
	public static void edgeBrowserLaunch() {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	}	
	
	//---------------------------------------------------------------------------
	public static void toLaunchUrl(String Url) {
	driver.get(Url);
	}
	public static void toMaximize() {
		driver.manage().window().maximize();
	}
	public static String toGetUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public static String toGetTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void closeBrowser() {
		toQuit();
	}
	//---------------------------------------------------------------------------
	public static String toGetText(WebElement element) {
		String text = element.getText();
		return text;	
	}
	public static String toGetAttribute(WebElement element) {
		String att = element.getAttribute("value");
		return att;
	}
	//------------------------------------------------------------------------
	public static void toType(WebElement loc, String value) {
		loc.sendKeys(value);
	}
	public static void toClick(WebElement loc) {
		loc.click();	
	}
	public static void toQuit() {
		driver.quit();
	}
	//----------------------------------------------------------------------
	
	public static void toMovetoElement(WebElement element) {
		acc=new Actions(driver);
		acc.moveToElement(element).perform();
		
	}
	public static void toDragAndDrop(WebElement src,WebElement dest) {
		acc=new Actions(driver);
		acc.dragAndDrop(src, dest).perform();
	}
	public static void toDoubleClick(WebElement target) {
		acc=new Actions(driver);
		acc.doubleClick(target).perform();
	}
	public static void toRightclick(WebElement element) {
		acc=new Actions(driver);
		acc.contextClick(element).perform();
	}
	//------------------------------------------------------------------------
	//Robot
	public static void robotEscape() throws AWTException {
		  arr=new Robot();
		  arr.keyPress(KeyEvent.VK_ESCAPE);
		  arr.keyPress(KeyEvent.VK_ESCAPE);
	}
      
       
	
	//----------------------------------------------------------------------------
	public static void getSnap(String filename) throws IOException {
    TakesScreenshot tk=(TakesScreenshot)driver;		
    File src = tk.getScreenshotAs(OutputType.FILE);
    File desc=new File("C:\\Users\\VIJILA\\eclipse-workspace\\Maven2\\Screenshot" +filename +" .png");
    FileUtils.copyFile(src, desc);
	}
	//-------------------------------------------------------------------------------
	//Alerts
	public static void alertAccept() {
	 a=driver.switchTo().alert();
	 a.accept();
	}
	 public static void alertDismiss() {
		 a=driver.switchTo().alert();
		 a.dismiss();
	}
	 public static void alertOk() {
		 a=driver.switchTo().alert();
		 a.sendKeys("yes");
		 a.accept();
	 }
	 public static void alertCancel() {
		 a=driver.switchTo().alert();
		 a.sendKeys("No");
		 a.dismiss();
	 }
	//------------------------------------------------------------------
	//JavascriptExecutor
	 public static void javascriptScrolldown(WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
	 }
	 
	 public static void javascriptScrollup(WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
	 }		
	 
	//-------------------------------------------------------------------------------------------
	//DropDown
	public static void toSelectByIndex(WebElement element, int index) {
		s=new Select(element);
		s.selectByIndex(index);
	}
	public static void toSelectByValue(WebElement element, String value) {
		s=new Select(element);
		s.selectByValue(value);
	}
	public static void toSelectByVisibleText(WebElement element, String value) {
		s=new Select(element);
		s.selectByVisibleText(value);
	}
	public static boolean toMultiple(WebElement element) {
		s=new Select(element);
		boolean b = s.isMultiple();
		return b;
	}
	public static void todeSelectByIndex(WebElement element, int index) {
		s=new Select(element);
		s.deselectByIndex(index);
	}
	public static void todeSelectByValue(WebElement element, String value) {
		s=new Select(element);
		s.deselectByValue(value);
	}
	public static void todeSelectByVisibleText(WebElement element, String value) {
		s=new Select(element);
		s.deselectByVisibleText(value);
	}
	//---------------------------------------------------------------------------------------------
	//frames
	public static void framesId(String id) {
		driver.switchTo().frame(id);
	}
	public static void framesName(String name) {
		driver.switchTo().frame(name);
	}
	public static void framesWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void framesIndex(int index) {
		driver.switchTo().frame(index);
	}
	public static void backToParent() {
		driver.switchTo().defaultContent();
	}
	//----------------------------------------------------------------------------------------------
	//WindowsHandling
	public static void windowHandle() {
		String par=driver.getWindowHandle();
		Set<String> all=driver.getWindowHandles();
		for(String x:all) {
			if(!par.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}
	
	public static void windowsHandles(int i) {
		Set<String> allWindows =driver.getWindowHandles();
		List<String> li=new ArrayList();
		li.addAll(allWindows);
		String s=li.get(i);
		driver.switchTo().window(s);
	}
	//-------------------------------------------------------------------------------------------------
	//webTable--Print all value in first row
    public static String firstRowValue(WebElement element, String web,int i) {
    	
    	  List<WebElement> allRows = element.findElements(By.tagName("tr"));
          
          WebElement row = allRows.get(i);
          String r = row.getText();
          return r;
        	  
	}
    //Print all the content in the dynamic webtable.
//    public static String toPrintAllValues(WebElement element,String tRows) {
//    	
//    List<WebElement> tRow = element.findElements(By.tagName("tr"));
//    for (int i = 0; i < tRow.size(); i++) {
//  	  WebElement row = tRow.get(i);
//  	      	
// 	
//  	List<WebElement> tData = row.findElements(By.tagName("td"));
//  	for (int j = 0; j < tData.size(); j++) {
//  		WebElement data = tData.get(j);
//  		String text2 = data.getText();
//     		//System.out.println(text2);
//  		return text2;
//  	}
//    }
//	return tRows;
//	
//    }
//			
	//------------------------------------------------------------------------------------------------
	//excel Read
	public static String excelRead(String fileName,String sheetName,int rowNo,int cellNo) throws IOException {
		
				File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
				FileInputStream stream=new FileInputStream(f);
				Workbook w = new XSSFWorkbook(stream);
				Sheet s = w.getSheet(sheetName);
				Row r = s.getRow(rowNo);
				Cell c = r.getCell(cellNo);
				String value = c.getStringCellValue();
				return value;
		
		
	}
	
//---------------------------------------------------------------------------------------------

//to fetch all the string,date ,number of value 	
public static void excelReadAll(String fileName,String sheetName) throws IOException{

File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
FileInputStream stream=new FileInputStream(f);
Workbook w=new XSSFWorkbook(stream);
Sheet s=w.getSheet(sheetName);

//to fetch all the string,date,number value 
int numberOfRows = s.getPhysicalNumberOfRows();
for (int i = 0; i < numberOfRows; i++) {
	Row r = s.getRow(i);

int numberOfCells = r.getPhysicalNumberOfCells();
for (int j = 0; j < numberOfCells; j++) {
	Cell c = r.getCell(j);
	
	
	//cellType==1 --->your cell is containing a string value
	//cellType is equal to other than 1---> number or date
	
	int cellType = c.getCellType();
//System.out.println(cellType);
  String value;
  
if(cellType==1) {
value=c.getStringCellValue();
}
else if (DateUtil.isCellDateFormatted(c)) {
Date d = c.getDateCellValue();

SimpleDateFormat sim=new SimpleDateFormat("dd/MM/YYYY");
value=sim.format(d);
}		

else {
double d = c.getNumericCellValue();
long l=(long)d;
value=String.valueOf(1);
}
System.out.println(value);
}
}

}

//---------------------------------------------------------------------------------------------------------------------------------
//to fetch single row value from excel sheet

public static void excelReadAllFormats(String fileName,String sheetName,int rowNo,int cellNo) throws IOException{

File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
FileInputStream stream=new FileInputStream(f);
Workbook w=new XSSFWorkbook(stream);
Sheet s=w.getSheet(sheetName);


	Row r = s.getRow(rowNo);


	Cell c = r.getCell(cellNo);
	
	
	//cellType==1 --->your cell is containing a string value
	//cellType is equal to other than 1---> number or date
	
	int cellType = c.getCellType();
//System.out.println(cellType);
  String value;
  
if(cellType==1) {
value=c.getStringCellValue();
}
else if (DateUtil.isCellDateFormatted(c)) {
Date d = c.getDateCellValue();

SimpleDateFormat sim=new SimpleDateFormat("dd/MM/YYYY");
value=sim.format(d);
}		

else {
double d = c.getNumericCellValue();
long l=(long)d;
value=String.valueOf(1);
}
System.out.println(value);
}

//-----------------------------------------------------------------------------------------------------------------------------------
//excel Write
public static void toCreateSheet(String fileName,String sheetName, int rowNo,int cellNo,String value) throws IOException {
	

File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
Workbook w=new XSSFWorkbook();
Sheet s = w.createSheet(sheetName);
Row r = s.createRow(rowNo);
Cell c=r.createCell(cellNo);
c.setCellValue(value);

FileOutputStream output=new FileOutputStream(f);
w.write(output);
System.out.println("Done");

}

//-----------------------------------------------------------
//excel update
public static void toUpdateSheet(String fileName, String sheetName,int rowNo, int cellNo,String oldVlaue,String newValue)throws IOException{
	File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
	
	FileInputStream stream=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet(sheetName);
	Row r = s.getRow(rowNo);
	Cell c=r.getCell(cellNo);
	//value->harishwar
	String value = c.getStringCellValue();
	
	//write
	if(value.contains("oldValue")) {
		c.setCellValue("newValue");
	}
	FileOutputStream output=new FileOutputStream(f);
	w.write(output);
	System.out.println("updated successfully");
		
}
//------------------------------------------------------------------------
//to write in a existing file
public static void toWriteExistingFile(String fileName,String sheetName,int rowNo, int cellNo,String value) throws IOException {
	File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
	
	FileInputStream stream=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet(sheetName);
	Row r = s.createRow(rowNo);
	Cell c=r.createCell(cellNo);
	
		c.setCellValue(value);
	
	FileOutputStream output=new FileOutputStream(f);
	w.write(output);
	
		
}
//-------------------------------------------------------------------------------------------------------------
//Waits

public static void threadSleep(int num) throws InterruptedException {
	Thread.sleep(num);
}
//implicit wait
public static void implicit(int num) {
	driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
}
private static void webdriverWaitTime(WebElement element,int number) {
	WebDriverWait w=new WebDriverWait(driver,number);
	w.until(ExpectedConditions.elementToBeClickable(element));
}
//---------------------------------------------------------------------------------------------
//Testng

public static  void getDateTime() {
	Date d=new Date();
	System.out.println(d);	
}
//--------------------------------------------------------------------------------------------
//to fetch single row value from excel sheet-----excel for dataprovider

public static Object excelReadAllFormats1(String fileName,String sheetName,int rowNo,int cellNo) throws IOException{

File f=new File("C:\\Users\\VIJILA\\eclipse-workspace\\MavenPro\\ExcelSheet\\"+fileName+".xlsx");
FileInputStream stream=new FileInputStream(f);
Workbook w=new XSSFWorkbook(stream);
Sheet s=w.getSheet(sheetName);


	Row r = s.getRow(rowNo);


	Cell c = r.getCell(cellNo);
	
	
	//cellType==1 --->your cell is containing a string value
	//cellType is equal to other than 1---> number or date
	
	int cellType = c.getCellType();
//System.out.println(cellType);
String value;

if(cellType==1) {
value=c.getStringCellValue();
}
else if (DateUtil.isCellDateFormatted(c)) {
Date d = c.getDateCellValue();

SimpleDateFormat sim=new SimpleDateFormat("dd/MM/YYYY");
value=sim.format(d);
}		

else {
double d = c.getNumericCellValue();
long l=(long)d;
value=String.valueOf(1);
}
System.out.println(value);
return value;
}


}




