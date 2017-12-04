package Maven_demo.Maven_demo1;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OTP {
	ChromeDriver Tracko;
	public OTP(ChromeDriver tracko2) {
		Tracko = tracko2;
	}
	public void otp(String Otp) throws InterruptedException {
		  Tracko.findElementByXPath("//input[@id='otp']").sendKeys(Otp);
	       // Tracko.findElementByXPath(" //button[@id='resendOtp_btn']").click();
	        
		  
		  WebElement element=Tracko.findElement(By.xpath("//button[@id='sub_btn_verify']"));//.click();
		  
		  Actions act=new Actions(Tracko);
		  act.moveToElement(element).click(element).build().perform();
	        //Tracko.switchTo().alert().accept();
	        Thread.sleep(4000);
	        Tracko.findElementByXPath("//button[@class='confirm']").click();
	        
	}
}
