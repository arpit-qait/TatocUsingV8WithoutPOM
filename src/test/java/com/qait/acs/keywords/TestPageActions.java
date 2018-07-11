package com.qait.acs.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.SampleDataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestPageActions extends GetPage {

	WebDriver driver;
	SampleDataProvider fileData;

	public TestPageActions(WebDriver driver) {
		super(driver, "testPage");
		this.driver = driver;
	}

	public void printSpecificRowData(String String) {
		System.out.println("+++++++++");
		logMessage("Demo String: '"+String+"'");
		System.out.println("+++++++++");
	}

	public void clickAnyElementOnWebsite() {
		element("Btn_FeelingLucky").click();
		logMessage("User clicked on 'I am feeling lucky' button.");
	}
        
        public void OpenBasicCourse(){
    element("basicCourseSelect").click();
} 
        public void ClickGreenBox(){
            element("greenbox").click();
        }
        
        public void MatchGridBoxes(){
            driver.switchTo().frame(0);
            String box_Color1 = element("firstbox").getAttribute("class");
            System.out.println(box_Color1);
            driver.switchTo().frame(0);
            String box_Color2 = element("secondbox").getAttribute("class");
            while(!box_Color1.equals(box_Color2)){
            driver.switchTo().parentFrame();
            element("Repaint").click();
            driver.switchTo().frame(0);
            box_Color2 = element("secondbox").getAttribute("class");
            
        }
            driver.switchTo().parentFrame();
            element("proceed").click();
        }
        public void DragANDDrop(){
            WebElement point =  element("Dropbox");
        
            WebElement point1 =  element("Dragbox");
            Actions act = new Actions(driver);
            act.dragAndDrop(point1, point).build().perform();
//        while()
            element("proceed").click();
        }
        
        public void PopupWindow(){
            element("popup").click();
            String parentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            //System.out.println(parentWindow);
            List<String> popups =new ArrayList<>(windows);
            String popupWindow = popups.get(popups.size()-1);
            //System.out.println(popupWindow);
            driver.switchTo().window(popupWindow);
            element("Name").sendKeys("Arpit");
            element("Submit").click();
            driver.switchTo().window(parentWindow);
            element("proceed").click();
        }
        public void COOKIE(){
            element("GenerateToken").click();
            String token = element("TOKEN").getText();
            //System.out.println(token.substring(7));
            driver.manage().addCookie(new Cookie("Token", token.substring(7)));
            element("proceed").click();
        }

}
