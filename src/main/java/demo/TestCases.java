package automationframework;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        //Testcase05: Upload image/video on linkedin
        public  void testCase05() throws InterruptedException{
        System.out.println("Start Test case: testCase05");
        driver.get("https://in.linkedin.com/");
    	driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(@href, 'signin')]")).click();
     	Thread.sleep(2000);
    	driver.findElement(By.id("username")).sendKeys("username");
    	driver.findElement(By.id("password")).sendKeys("password");
    	driver.findElement(By.xpath("//button[text()= 'Sign in']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("ember47")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class='artdeco-carousel__content']/descendant::button[1][@class='share-promoted-detour-button']")).click();
    	Thread.sleep(2000);
    	WebElement imageButton=driver.findElement(By.xpath("//input[@id='media-editor-file-selector__file-input']"));
    	imageButton.sendKeys("D:\\Eclipse\\QA_Automation\\pic_shubham.jpg");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//h2[@id='share-to-linkedin-modal__header']/button/div")).click();
    	driver.findElement(By.id("CONNECTIONS_ONLY")).click();
    	driver.findElement(By.xpath("//span[text()='Done']")).click();
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(5000);
        if(driver.findElement(By.xpath("//span[text()='Post successful.']")).getText().contains("successful"))
        System.out.println("post successful");
        System.out.println("end Test case: testCase05");
    }
        //Testcase06: Nested Frames
        public  void testCase06() throws InterruptedException{
            System.out.println("Start Test case: testCase06");
            driver.get("https://the-internet.herokuapp.com/nested_frames");
        	driver.manage().window().maximize();
        	driver.switchTo().frame("frame-top");
        	driver.switchTo().frame("frame-left");
        	WebElement leftFrame = driver.findElement(By.tagName("body"));
        	System.out.println(leftFrame.getText());
        	driver.switchTo().parentFrame();
        	driver.switchTo().frame("frame-middle");
        	WebElement middleFrame = driver.findElement(By.tagName("body"));
        	System.out.println(middleFrame.getText());
        	driver.switchTo().parentFrame();
        	driver.switchTo().frame("frame-right");
        	WebElement rightFrame = driver.findElement(By.tagName("body"));
        	System.out.println(rightFrame.getText());
        	driver.switchTo().defaultContent();
        	driver.switchTo().frame("frame-bottom");
        	WebElement bottomFrame = driver.findElement(By.tagName("body"));
        	System.out.println(bottomFrame.getText());
        	driver.switchTo().defaultContent();
            System.out.println("end Test case: testCase06");
        }
        //Testcase07: Alert prompt
        public  void testCase07() throws InterruptedException{
        System.out.println("Start Test case: testCase07");
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//p[text()='Add Remarks']")).click();
    	driver.switchTo().alert().sendKeys("shubhamcrio");
    	driver.switchTo().alert().accept();
    	String text=driver.findElement(By.xpath("//p[@class='Alert_remarkContent']")).getText();
    	if(text.contentEquals("shubhamcrio"))
    		System.out.println("alert content printed");
        System.out.println("end Test case: testCase07");
}
        //Testcase08: Imdb rating
        public  void testCase08() throws InterruptedException{
        System.out.println("Start Test case: testCase08");
        driver.get("https://www.imdb.com/chart/top");
    	JavascriptExecutor js= (JavascriptExecutor) driver;
    	WebElement dropDownButton= driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
    	js.executeScript("arguments[0].scrollIntoView();", dropDownButton);
    	dropDownButton.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='IMDb rating']")).click();
    	Thread.sleep(3000);
        List<WebElement> moviesCount= driver.findElements(By.xpath("//ul[contains(@class, 'compact-list-view ')]/li"));
        WebElement highestRated= driver.findElement(By.xpath("//ul[contains(@class, 'compact-list-view ')]/li[1]/descendant::h3"));
        System.out.println("highest rated movie on IMDb: "+highestRated.getText());
        System.out.println("Count of  movies are included in the table: "+ moviesCount.size());
        driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='Release date']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("swap-sort-order-button")).click();
        Thread.sleep(2000);
        WebElement Movie= driver.findElement(By.xpath("//ul[contains(@class, 'compact-list-view ')]/li[1]/descendant::h3"));
        System.out.println("oldest movie on the list: "+Movie.getText());
        driver.findElement(By.id("swap-sort-order-button")).click();
        Thread.sleep(2000);
        System.out.println("recent movie on the list: "+Movie.getText());
        driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='Number of ratings']")).click();
        Thread.sleep(2000);
        WebElement recentMovie= driver.findElement(By.xpath("//ul[contains(@class, 'compact-list-view ')]/li[1]/descendant::h3"));
        System.out.println("movie which has the most user ratings: "+ recentMovie.getText());
        System.out.println("end Test case: testCase08");
}
        //Testcase09: Window handler
        public  void testCase09() throws InterruptedException{
        System.out.println("Start Test case: testCase09");
      	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
    	String parentWindowHandle = driver.getWindowHandle();
    	driver.switchTo().frame("iframeResult");
    	driver.findElement(By.xpath("//button[text()='Try it']")).click();
    	Thread.sleep(3000);
    	Set<String> allWindowHandles = driver.getWindowHandles(); 
    	for(String newWindow: allWindowHandles) {
    		if(!newWindow.equals(parentWindowHandle)) {
    			driver.switchTo().window(newWindow);     
    		System.out.println(driver.getCurrentUrl());
    		System.out.println(driver.getTitle());
    		new App().takeScreenshot(driver, "newWindow", "screenshot");
    		driver.close();
    		}}
    	driver.switchTo().window(parentWindowHandle);
        System.out.println("end Test case: testCase09");
}
}