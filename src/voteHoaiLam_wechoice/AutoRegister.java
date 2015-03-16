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
	private static BufferedReader configBufferedReader;
	private static String configLine;
	private static int configTimeout;
	private static String configPassword;
	private static String configName;
	
	public static void main(String[] args) throws IOException {
		File config_file = new File ("config.txt");
		FileReader configReader = new FileReader (config_file);
		configBufferedReader = new BufferedReader(configReader);
		while ((configLine = configBufferedReader.readLine()) != null) {
			String[] lines = configLine.split("=");
			if (lines[0].compareTo("password") == 0) {
				configPassword = lines [1];
			}
			if (lines[0].compareTo("timeout") == 0) {
				configTimeout = Integer.parseInt(lines [1]);
			}
			if (lines[0].compareTo("name") == 0) {
				configName = lines [1];
			}
		}
		
		File file = new File("email.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			WebDriver driver = new ChromeDriver();
			// TODO Auto-generated method stub
			driver.manage().timeouts().implicitlyWait(configTimeout, TimeUnit.SECONDS);
			driver.get("http://vietid.net");
			WebElement email_addr = driver.findElement(By.id("email"));
			WebElement password1 = driver.findElement(By.id("password"));
			WebElement password2 = driver.findElement(By.id("re_password"));
			WebElement full_name = driver.findElement(By.id("fullname"));
			
			email_addr.sendKeys(line);
			password1.sendKeys(configPassword);
			password2.sendKeys(configPassword);
			full_name.sendKeys(configName);
			
			WebElement register_button = driver.findElement(By.id("register_vietid"));
			register_button.click();
			
			driver.quit();
		}
		fileReader.close();
		
		
	}

}
