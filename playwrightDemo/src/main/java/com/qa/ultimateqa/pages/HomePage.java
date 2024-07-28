package com.qa.ultimateqa.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    // locators
    private String usernameSelector = "#user-name";
    private String passwordSelector = "#password";
    private String loginbtn = "#login-button";
    private String title = "[data-test=\"title\"]";


    // page constructor
    public HomePage(Page page){
        this.page = page;
    }

    // methods
    public String login(String username, String password){
        page.fill(usernameSelector, username);
        page.fill(passwordSelector, password);
        page.click(loginbtn);
        return page.textContent(title);
    }


    public String getPageTitle() {
        return page.title();
    }
}
