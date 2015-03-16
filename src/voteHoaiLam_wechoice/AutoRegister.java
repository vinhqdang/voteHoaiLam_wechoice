package voteHoaiLam_wechoice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoRegister { 
	public static void main(String[] args) throws IOException {
		
		File file = new File("email.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			WebDriver driver = new ChromeDriver();
			// TODO Auto-generated method stub
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://vietid.net");
			WebElement email_addr = driver.findElement(By.id("email"));
			WebElement password1 = driver.findElement(By.id("password"));
			WebElement password2 = driver.findElement(By.id("re_password"));
			WebElement full_name = driver.findElement(By.id("fullname"));
			
			email_addr.sendKeys(line);
			password1.sendKeys("123456");
			password2.sendKeys("123456");
			full_name.sendKeys("ABC XYZ DEF");
			
			WebElement register_button = driver.findElement(By.id("register_vietid"));
			register_button.click();
			
			driver.quit();
		}
		fileReader.close();
		
		
	}

}
