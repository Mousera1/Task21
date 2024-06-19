package seleniumjava;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTask21 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement click = driver.findElement(By.linkText("Click Here"));
        click.click();
        
        Set<String> popupID = driver.getWindowHandles();
        System.out.println(popupID);
        
        Iterator<String> abc = popupID.iterator();
        String Window1 = abc.next();
        String Window2 = abc.next();
        driver.switchTo().window(Window2);
        System.out.println(Window2);
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(Window1);
        System.out.println(driver.getTitle()); // verification of Window1 being active
        driver.quit();

	}

}
