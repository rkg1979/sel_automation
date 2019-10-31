package edurekaproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstClass {
	public static boolean Test_fail = false;
	public static SoftAssert st;
	public static WebDriver driver;
  @Test
  public void f() throws Throwable {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
      driver=new ChromeDriver(); //open browser
      driver.manage().window().maximize(); //maximize browser window
      driver.get("http://35.244.22.114:9191/website/");
      driver.findElement(By.xpath("//a[@id='About Us']")).click();
      verifySuccessMsg();
      assertall();
      driver.close();
  }
  public void verifySuccessMsg() throws Throwable{
	  try {
		  Test_fail = false;
		  driver.findElement(By.xpath("//p[@id='PID-ab2-pg']")).isDisplayed();
	  }catch(Throwable t){
		  Test_fail = true;
	  }
  }
  public void assertall(){
		if(Test_fail){
		st.assertAll();
		}
	}
}
