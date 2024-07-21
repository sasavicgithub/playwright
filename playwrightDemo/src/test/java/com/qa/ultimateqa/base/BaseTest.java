package com.qa.ultimateqa.base;

import com.microsoft.playwright.Page;
import com.qa.ultimateqa.PlaywrightFactory;
import com.qa.ultimateqa.pages.HomePage;
import com.qa.ultimateqa.pages.MainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {


    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected MainPage mainPage;
    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
        mainPage = new MainPage(page);

        // Perform login as precondition
        String username = prop.getProperty("loginUsername").trim();
        String password = prop.getProperty("loginPassword").trim();
        homePage.login(username, password);

    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
