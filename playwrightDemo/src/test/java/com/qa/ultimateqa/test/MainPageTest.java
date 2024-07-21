package com.qa.ultimateqa.test;

import com.qa.ultimateqa.base.BaseTest;
import com.qa.ultimateqa.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MainPageTest extends BaseTest {

    @Test
    public void testProductSortFilterClick() {
       mainPage.productSortFilter();
        // Add assertions if needed to verify the result of clicking the product sort filter
    }

    @Test
    public void testGetProductSortFilterText() {
        String text = mainPage.getProductSortFilter();
        // Replace "Expected Text" with the actual expected text
      //  Assert.assertEquals(text, "Expected Text");
    }

    @Test
    public void testTwitterLinkClick() {
        mainPage.clickTwitterLink();
        // Add assertions if needed to verify the result of clicking the Twitter link
    }

    @Test
    public void testGetTwitterLinkText() {
        String text = mainPage.getTwitterLinkText();
     //  Assert.assertEquals(text, "Twitter");
    }
}
