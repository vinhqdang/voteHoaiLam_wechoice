package voteHoaiLam_wechoice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoVote { 
	private static BufferedReader bufferedReader;
	private static BufferedReader configBufferedReader;
	private static String configLine;
	private static int configTimeout;
	private static String configPassword;
	private static String configName;
	private static int waitTime;	//time to wait to vote again

	public static void main(String[] args) throws InterruptedException, IOException {
		
		if (OSValidator.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		
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
			if (lines[0].compareTo("wait") == 0) {
				waitTime = Integer.parseInt(lines [1]);
			}
		}
		
		File file = new File("email.txt");
		FileReader fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			WebDriver driver = new ChromeDriver();
			// TODO Auto-generated method stub
			driver.manage().timeouts().implicitlyWait(configTimeout, TimeUnit.SECONDS);
			driver.get("http://vietid.net");
			WebElement username = driver.findElement(By.name("username"));
			WebElement password = driver.findElement(By.name("password"));

			username.sendKeys(line);
			password.sendKeys(configPassword);
			password.sendKeys(Keys.RETURN);
			
			Thread.sleep(5000);

			driver.get("http://wechoice.vn");

			WebElement vote_button = driver.findElement(By.xpath("//*[@id=\"WrapperTag\"]/div[2]/div[4]/div[2]/div[2]/ul/li[1]/div/div"));
			vote_button.click();

			Thread.sleep (waitTime * 1000);

			driver.quit();
		}
	}

}
