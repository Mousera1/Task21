package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTopBottomTask21 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-top']")));
        System.out.println("Switched to Top frame");
        int frames = driver.findElements(By.tagName("frame")).size();
        System.out.println("Total frames: " + frames);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-left']")));
        System.out.println("Switched to Left frame");
        WebElement leftframe = driver.findElement(By.tagName("body"));
        System.out.println(leftframe.getText());
        driver.switchTo().parentFrame();
        System.out.println("Switched back to Top frame");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-middle']")));
        WebElement midframe = driver.findElement(By.tagName("body"));
        System.out.println("Switched to Middle frame");
        System.out.println(midframe.getText());
        driver.switchTo().parentFrame();
        System.out.println("Switched back to Top frame");
        
        
	}

}
