package automationframework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        ChromeOptions co= new ChromeOptions();
    	co.addArguments("('--disable-blink-features=AutomationControlled')");
    	co.setBrowserVersion("116");
        ChromeDriver driver = new ChromeDriver(co);
        this.driver= driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        this.driver.close();
        driver.quit();

    }

    //Testcase01: Search amazon
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@id= 'APjFqb']")).sendKeys("amazon");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
        Thread.sleep(3000);
        List<WebElement> content= driver.findElements(By.xpath("//a[contains(@href,'amazon.in') or contains(@href,'amazon.com')]"));
        if(content.size()>0)
        	System.out.println("true");
        System.out.println("end Test case: testCase01");
    }
    

    //Testcase02: Count hyperlinks
    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> links= driver.findElements(By.tagName("a"));
        int count= links.size();
        System.out.println("Count of all links on webpage: "+ count);
        System.out.println("end Test case: testCase02");
    }

    //Testcase03: Post on linkedin
    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://in.linkedin.com/");
    	driver.findElement(By.xpath("//a[contains(@href, 'signin')]")).click();
     	Thread.sleep(2000);
    	driver.findElement(By.id("username")).sendKeys("***********");
    	driver.findElement(By.id("password")).sendKeys("****");
    	driver.findElement(By.xpath("//button[text()= 'Sign in']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("ember47")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("hello all connections");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//h2[@id='share-to-linkedin-modal__header']/button/div")).click();
    	driver.findElement(By.id("CONNECTIONS_ONLY")).click();
    	driver.findElement(By.xpath("//span[text()='Done']")).click();
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        driver.findElement(By.xpath("//div[@class='t-16 t-black t-bold' or text()='Shubham Paliwal']")).click();
        Thread.sleep(3000);
        String text=driver.findElement(By.xpath("//div[@class='mb3']/following-sibling::div/descendant::div[contains(@class, 'collapsed')]/span")).getText();
        if(text.equals("hello all connections"))
        System.out.println("post successful");
        System.out.println("end Test case: testCase03");
    }
    

    //Testcase04: Image Urls
    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.findElement(By.xpath("//div[text()='See All ›']")).click();
        Thread.sleep(3000);
        List <WebElement> Element=driver.findElements(By.xpath("//div[@id='super-wrapper']/descendant::div[@class='sc-1ljcxl3-0 iGFUdZ']/a/descendant::img"));
		   System.out.println(Element.size());
     	int count=0;
     	for(WebElement imglink: Element) {
     		System.out.println(imglink.getAttribute("src"));
     		count++;
     	}
     	System.out.println("count of img links for recommended movies: "+count);
        System.out.println("end Test case: testCase04");
    }

}
