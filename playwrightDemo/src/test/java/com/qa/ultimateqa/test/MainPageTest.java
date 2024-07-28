package com.qa.ultimateqa.test;

import com.qa.ultimateqa.base.BaseTest;
import com.qa.ultimateqa.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
    MainPage mainPage;

    @BeforeClass
    public void setupMainPage() {
        mainPage = new MainPage(page);
    }

    @Test
    public void testGetProductSortFilterText() {
        System.out.println("MainPage instance: " + mainPage);
        String filterText = mainPage.getProductSortFilter();
        Assert.assertNotNull(filterText, "Filter text is null");
    }

    @Test
    public void testGetTwitterLinkText() {
        System.out.println("MainPage instance: " + mainPage);
        String twitterText = mainPage.getTwitterLinkText();
        Assert.assertNotNull(twitterText, "Twitter text is null");
    }

    @Test
    public void testProductSortFilterClick() {
        System.out.println("MainPage instance: " + mainPage);
        mainPage.productSortFilter();
        // Add necessary assertions to verify the click action
    }

    @Test
    public void testTwitterLinkClick() {
        System.out.println("MainPage instance: " + mainPage);
        mainPage.clickTwitterLink();
        // Add necessary assertions to verify the click action
    }
}
