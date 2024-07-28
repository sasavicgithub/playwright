package com.qa.ultimateqa.test;

import com.qa.ultimateqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.ultimateqa.constants.AppConstant.HOME_PAGE_TITLE;

;


public class HomePageTest extends BaseTest {
    @Test
    public void testLogin() {
        // The login is already performed in BaseTest setup
        String titleText = homePage.getPageTitle();
        // Assert that the title text is as expected after login
        Assert.assertEquals(titleText, HOME_PAGE_TITLE, "Title is not correct for this page");
    }

    }



