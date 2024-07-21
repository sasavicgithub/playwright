package com.qa.ultimateqa.test;

import com.microsoft.playwright.Page;
import com.qa.ultimateqa.PlaywrightFactory;
import com.qa.ultimateqa.base.BaseTest;;
import org.testng.Assert;

import org.testng.annotations.Test;

import static com.qa.ultimateqa.constants.AppConstant.LOGIN_PAGE_TITLE;


public class HomePageTest extends BaseTest {
    @Test
    public void testLogin() {


        String username = prop.getProperty("loginUsername").trim();
        String password = prop.getProperty("loginPassword").trim();
        String titleText = homePage.login(username, password);
        // Assert that the title text is as expected after login
        Assert.assertEquals(titleText, LOGIN_PAGE_TITLE, "Title is not correct for this page");
    }


}
