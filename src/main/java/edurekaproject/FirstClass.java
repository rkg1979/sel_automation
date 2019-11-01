package edurekaproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstClass {
	public static boolean Test_fail = false;
	public static SoftAssert st;
	public static WebDriver driver;
  @Test
  public void testcase() throws Throwable{
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.setHeadless(true);
	  chromeOptions.addArguments("--headless");
	  chromeOptions.addArguments("--no-sandbox");
      driver=new ChromeDriver(chromeOptions); //open browser
      driver.manage().window().maximize(); //maximize browser window
      driver.get("http://34.93.135.215:9001/website/");
      driver.findElement(By.xpath("//a[@id='About Us']")).click();
      verifySuccessMsg();
      driver.close();
      if(Test_fail){
    	  st.assertAll();
      }
      
  }
  public void verifySuccessMsg() throws Throwable{
	  try {
		  Test_fail = false;
		  driver.findElement(By.xpath("//p[@id='PID-ab2-pg']")).isDisplayed();
	  }catch(Throwable t){
		  Test_fail = true;
		  st= new SoftAssert();
		  st.fail("All about page is not displayed");
		  //driver.findElement(By.xpath("//*[contains(text(),'Apache')]")).isDisplayed();
	  }
  }
	/*
	 * public void assertall(){ if(Test_fail){ st.assertAll(); } }
	 */
}

