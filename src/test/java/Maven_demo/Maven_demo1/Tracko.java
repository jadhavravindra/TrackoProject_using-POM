package Maven_demo.Maven_demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tracko {
	ChromeDriver Tracko;
	String name="TrackoTest";
	String Email;
	String Mobile;
	String Otp="123456";
	String password="Test@12345";
	@BeforeClass
	public void beforeClass() {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		Tracko = new ChromeDriver(opt);
		Tracko.get("https://dev.tracko.co.in/");
		Tracko.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Tracko.manage().window().maximize();
	}

	@Test(priority=1)
	public void f() throws InterruptedException 
	{
		
		Utility_Package ref = new Utility_Package();      //utility package
		int num1=ref.randomNum();
		Email="tracko"+num1+"20@gmail.com";
		
		int num2=ref.randomNum();
		Mobile="83"+num2+"875949";
				
		
		SignUp signup=new SignUp(Tracko);				//for Sign up
		signup.sign(name,Email,Mobile,Otp,password);

		

		Thread.sleep(2000);
		OTP O=new OTP(Tracko);						//for OTP
		O.otp(Otp);

		
		//Thread.sleep(2000);
		SET_PASSWORD SP=new SET_PASSWORD(Tracko);		//for Set Password
		SP.Set_Pass(password);
		Thread.sleep(2000);
		LOGIN l = new LOGIN(Tracko);
		l.login(Email,password,Mobile);


		/*LOGIN L=new LOGIN(Tracko);					//for Login
        L.login();
		 */
		//Thread.sleep(2000);
		Product_Details PD=new Product_Details(Tracko);	//for product details
		System.out.println("this is in product details");
		PD.product_detail();
		Thread.sleep(2000);
		Delivery_Address DA=new Delivery_Address(Tracko);     //For Address details
		DA.delivery_address();

	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("Hii This is after test "); 
		//Thread.sleep(5000);
		Tracko.quit();
	}
}
