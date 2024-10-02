package ui_cum_page_object;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ui_cum_step_definitions.CommonStep;
import ui_cum_utilities.DriverManager;




public class BrokenLink {
	
	private static BrokenLink brokenLinkInstances;
	private BrokenLink() {
	
	}	
	public static BrokenLink gettInstances() {
		if(brokenLinkInstances == null) {
			brokenLinkInstances = new BrokenLink();
		}
		return brokenLinkInstances;
	}
	
	public static Logger log = LogManager.getLogger(CommonStep.class);
	
	public void broken() {
		WebDriver driver = DriverManager.getDriver(); 
		List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links are = " +links.size());
        List<String> urlList = new ArrayList<String>();

// Iterate through the links and check their status
        for (WebElement link : links) {
        String url = link.getAttribute("href");
        urlList.add(url);
    //checkBrokenLink(url);
}

        long stTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(link ->  checkBrokenLink(link));
        long endTime = System.currentTimeMillis();
        
        System.out.println("Total time taken  : " + (endTime - stTime));
        
        driver.quit();
    }

	private static void checkBrokenLink(String urlLink) {
        try {
            URL url = new URL(urlLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            
            

            if ( httpURLConnection.getResponseCode() >= 400) {
                System.out.println(urlLink + "------> "+ httpURLConnection.getResponseMessage() + "--->"+ httpURLConnection.getResponseCode() + " The Link is broken ");
            
            } else {
                System.out.println(urlLink +"------>" + httpURLConnection.getResponseMessage() + "--->"+ httpURLConnection.getResponseCode() + " The Link is Working ");
                
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + urlLink);
        } catch (IOException e) {
            System.out.println("Error checking link: " + urlLink + " - " + e.getMessage());
        }
    }
}