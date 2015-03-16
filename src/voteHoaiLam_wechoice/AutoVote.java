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

	public static void main(String[] args) throws InterruptedException, IOException {
		File file = new File("email.txt");
		FileReader fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			WebDriver driver = new ChromeDriver();
			// TODO Auto-generated method stub
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://vietid.net");
			WebElement username = driver.findElement(By.name("username"));
			WebElement password = driver.findElement(By.name("password"));

			username.sendKeys(line);
			password.sendKeys("123456");
			password.sendKeys(Keys.RETURN);
			
			Thread.sleep(5000);

			driver.get("http://wechoice.vn");

			WebElement vote_button = driver.findElement(By.xpath("//*[@id=\"WrapperTag\"]/div[2]/div[4]/div[2]/div[2]/ul/li[1]/div/div"));
			vote_button.click();

			Thread.sleep (3000);

			driver.quit();
		}
	}

}
