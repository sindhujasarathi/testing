import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windowhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		 WebElement link=driver.findElement(By.xpath("//*[@id=\"multiplewindow\"]")); 
		link.click();
		Set<String> Windows=driver.getWindowHandles();//set used to store unique values
		Iterator<String>it=Windows.iterator();
		String parentWindow= it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		WebElement text=driver.findElement (By.xpath("//*[@id=\"popuptext\"]"));
		//text.click();
		System.out.println(text.getText());
		driver.switchTo().window(parentWindow);
		driver.quit();
		

	}

}
