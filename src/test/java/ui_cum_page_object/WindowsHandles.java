package ui_cum_page_object;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ui_cum_utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

	public class WindowsHandles {

public void windowsHand() {
	WebDriver driver = DriverManager.getDriver(); 
	        // Maximize the window and set implicit wait
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Open the first tab (default one)
	        driver.get("https://example.com");

	        // Open 9 additional tabs
	        for (int i = 1; i <= 9; i++) {
	            // Use JavaScript to open a new tab
	            ((ChromeDriver) driver).executeScript("window.open('about:blank','_blank');");
	        }

	        // Get all window handles (unique identifiers for each tab)
	        Set<String> windowHandles = driver.getWindowHandles();
	        System.out.println("Total number of tabs opened: " + windowHandles.size());

	        // Convert Set to List to access by index
	        List<String> windowHandlesList = new ArrayList<>(windowHandles);

	        // Switch to the 3rd tab (index 2)
	        driver.switchTo().window(windowHandlesList.get(2));

	        // Navigate to a different URL on the 3rd tab
	        driver.get("https://selenium.dev");

	        // Just for demo, sleep for a few seconds to see the change
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Close all the tabs
	        driver.quit();
	    }
	}
	
