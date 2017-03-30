package TestScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodingAssessment {

	/**
	 * Author: Alpesh
	 * Date: 29/03/2017
	 * Description: Verify the following information are displayed in any 5 links (you need to get the
					following bullets taking 5 links from the 10 mentioned) under the top 10 movie searches section of this URL: http://www.tcm.com/tcmdb/
	 */
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://www.tcm.com/tcmdb/");
		driver.manage().window().maximize();
		
		int iMoviesCnt = driver.findElements(By.xpath("//div[@id='movieSearchList']//a")).size();
		
		for(int i=1;i<=5;i++){
			String sMovieName = driver.findElement(By.xpath("//div[@id='movieSearchList']//a["+i+"]")).getText();
			int iIndex = sMovieName.indexOf("(");
			sMovieName = sMovieName.substring(0,iIndex).trim();
			//System.out.println(sMovieName);			
			Map objMovieDetails = HelperMethods.GetMovieInformation(sMovieName);		
			
			driver.findElement(By.xpath("//div[@id='movieSearchList']//a["+i+"]")).click();			
			WaitUntilBrowserIsCompletelyLoaded();
			
			String sTitle = driver.findElement(By.xpath("(//div[@id='dbartimgtitle']//span)[1]")).getText();
			String sOverview = driver.findElement(By.xpath("(//p[@class='bsynopsis'])[1]")).getText();
			String sYear = driver.findElement(By.xpath("//table[@class='dvd-add-details tbl1']/tbody/tr[2]/td[2]")).getText();
			boolean bActorName1 = driver.findElement(By.xpath("//a[normalize-space(text())='"+objMovieDetails.get("actor1")+"']")).isDisplayed();
			boolean bActorName2 = driver.findElement(By.xpath("//a[normalize-space(text())='"+objMovieDetails.get("actor2")+"']")).isDisplayed();
			System.out.println("************** Start of "+sMovieName+ " Data Validation ***********************");	
			
			if(sTitle.trim().equals(sMovieName)){
				System.out.println("Pass: Title Information is Matched for Movie "+sMovieName);
			}else{
				System.out.println("Fail: Title Information is not Matched for Movie "+sMovieName);
			}
			
			if(sOverview.trim().equals(objMovieDetails.get("overview"))){
				System.out.println("Pass: Overview Information is Matched for Movie "+sMovieName);
			}else{
				System.out.println("Fail: Overview Information is not Matched for Movie "+sMovieName);
			}
			
			if(bActorName1){
				System.out.println("Pass: Actor1 Information is Matched for Movie "+sMovieName);
			}else{
				System.out.println("Fail: Actor1 Information is not Matched for Movie "+sMovieName);
			}
			
			if(bActorName2){
				System.out.println("Pass: Actor2 Information is Matched for Movie "+sMovieName);
			}else{
				System.out.println("Fail: Actor2 Information is not Matched for Movie "+sMovieName);
			}
			
			if(sYear.trim().equals(objMovieDetails.get("year"))){
				System.out.println("Pass: Year Information is Matched for Movie "+sMovieName);
			}else{
				System.out.println("Fail: Year Information is not Matched for Movie "+sMovieName);
			}
			
			System.out.println("************** End of "+sMovieName+ " Data Validation ***********************");
			driver.navigate().back();
			WaitUntilBrowserIsCompletelyLoaded();
		}
		
		driver.quit();
	}
	
	public static void WaitUntilBrowserIsCompletelyLoaded(){
		JavascriptExecutor objJS = ((JavascriptExecutor) driver);
		String status = objJS.executeScript("return document.readyState").toString();		
		while(!(status.equals("complete"))){
			try{
				Thread.sleep(1000);
			}catch(Exception e){				
			}
			status = objJS.executeScript("return document.readyState").toString();
		}
	}
}
