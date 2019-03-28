package DriverFactory;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utilities.PropertyFileUtil;


public class Rough 

{


	public void hi() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);

		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();

		Thread.sleep(5000);
		List<WebElement> sGetTagNames =  driver.findElements(By.tagName("p"));
		System.out.println(sGetTagNames.size());

		TrueFalse = false;
		for (int i=0;i<=sGetTagNames.size()-1;i++)
		{
			String value = sGetTagNames.get(i).getAttribute("id");
			if (value.equalsIgnoreCase("_zipCityStateMessage"))
				TrueFalse = true;            
			if (TrueFalse)
			{
				sGetTagNames.get(i).findElement(By.tagName("span")).click();    
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='Please click here to select a city and State']/descendant::a")).click();   
				break;
			}
		}

		String aa=driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).getAttribute("Value");
		System.out.println(aa);

		Select select = new Select(driver.findElement(By.xpath("//select[contains(@name,'MailingAddress') and contains(@id,'StateProvCd')]")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);

	}



	public void NewCode() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02769");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);


		try {
			WebElement link_pleaseClickHereToSelectCityAndState = driver.findElement(By.id("_zipCityStateSelectionHelper"));
			if(link_pleaseClickHereToSelectCityAndState.isDisplayed())
			{
				link_pleaseClickHereToSelectCityAndState.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void Testing() throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Personal Auto");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02769");		
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);
		driver.findElement(By.id("continueButton")).click();

		WebElement alert_getAlertId = driver.findElement(By.id("alert"));
		List<WebElement> alert_getAllTheAlerts = alert_getAlertId.findElements(By.tagName("p"));
		System.out.println(alert_getAllTheAlerts.size());

		String sActualAlertMessage="Applicant First Name is a required field.".replace(" ", "");
		System.out.println(sActualAlertMessage);
		String sExpectedAlertMessage;

		for(int i=0;i<=alert_getAllTheAlerts.size()-1;i++)
		{
			sExpectedAlertMessage = alert_getAllTheAlerts.get(i).getText().replace(" ", "");
			System.out.println(sExpectedAlertMessage);

			if (sExpectedAlertMessage.contains(sActualAlertMessage))
			{
				System.out.println("Displayed");
				break;
			}

		}



	}


	public void Testing_GuiValidationsLinks(String sInputData ) throws InterruptedException
	{
		boolean  TrueFalse = false;
		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);

		Thread.sleep(3000);
		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);

		/*	List<WebElement> sGetSubLinks= driver.findElements(By.xpath(sInputData));	 
		 for (int i=0; i<=sGetSubLinks.size()-1;i++)
		 {
			 String sLinks = sGetSubLinks.get(i).getAttribute("innerText");
			 System.out.println(sLinks);
		 }*/

		WebElement sGetSubLink= driver.findElement(By.xpath(sInputData));
		sGetSubLink.click();
	}



	public void click_Zip() throws InterruptedException
	{

		System.setProperty("webdriver.ie.driver", "./CommonJarFile/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://staging99.arbella.com");
		driver.findElement(By.name("username")).sendKeys("Cigniti");	
		driver.findElement(By.name("password")).sendKeys("Arb3lla01");		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);



		Select s=new Select(driver.findElement(By.id("plNewBizSelect")));
		s.selectByVisibleText("Homeowners");
		driver.findElement(By.xpath("//select[@id='plNewBizSelect']/following-sibling::span/input[@value='Start']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'PostalCode'))]")).sendKeys("02163");	
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress') and (contains(@name,'City'))]")).click();		
		Thread.sleep(3000);
		
		driver.findElement(By.id("_zipCityStateSelectionHelper")).click();	
		Thread.sleep(3000);

		List<WebElement> abc=     driver.findElements(By.xpath("//td[text()='Please click here to select a city and State']/descendant::a"));

		for (int i=0;i<=abc.size();i++)
		{
			String a =  abc.get(i).getAttribute("href");
			if(a.contains("CAMBRIDGE"))

			{
				abc.get(i).click();
				break;
			}


		}
	}

		public static void main(String[] args) throws InterruptedException 
		{

			Rough SampleCode = new Rough();
			//SampleCode.NewCode();
			//SampleCode.Testing_GuiValidationsLinks("//li[@class='imatm topMenuItem_standard']/a[text()='Work In Progress']/../div[@class='imsc']/div[@class='imsubc']/ul/li/a");
			//SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\")]");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\",'s Comp Search')]/ancestor::li/a[text()='Commercial Lines']");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()=concat('Worker',\"'\",'s Comp Inbox')]/ancestor::li/a[text()='Commercial Lines']");
			//		SampleCode.Testing_GuiValidationsLinks("//a[text()='CL Inbox']/ancestor::li/a[text()='Commercial Lines']");
			SampleCode.click_Zip();
		}


	}
