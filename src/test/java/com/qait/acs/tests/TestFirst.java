package com.qait.acs.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import org.testng.annotations.Test;

public class TestFirst extends BaseTest {

//	@Test
	public void Step01_Launch_Application() {
		test.launchApplication(getYamlValue("baseUrl"));
	}
	
//	@Test
	public void Step02_DemoTest(){
		test.testPage.printSpecificRowData("This is a demo run...!!");
		test.testPage.clickAnyElementOnWebsite();
	}
        @Test(priority = 0)
        public void OpenCourse(){
            test.testPage.OpenBasicCourse();
        }
        @Test(priority = 1)
        public void ClickGreenBox(){
            test.testPage.ClickGreenBox();
        }
        @Test(priority = 2)
        public void MatchBoxColor(){
            test.testPage.MatchGridBoxes();
        }
        @Test(priority = 3)
        public void DragAndDrop(){
            test.testPage.DragANDDrop();
        }
        @Test(priority = 4)
        public void PoPupWindow(){
            test.testPage.PopupWindow();
        }
        @Test(priority = 5)
        public void Cookie(){
            test.testPage.COOKIE();
        }
}
