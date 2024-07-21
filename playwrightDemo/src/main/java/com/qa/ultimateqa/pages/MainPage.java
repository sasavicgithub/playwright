package com.qa.ultimateqa.pages;

import com.microsoft.playwright.Page;

public class MainPage{
    Page mainpage;

    // locators
    private String productSort = ".product_sort_container";
    private String twitterLinkSelector = "a[data-test='social-twitter']";



    // page constructor
    public MainPage(Page mainPage){
        this.mainpage = mainPage;
    }

    // methods
    public void productSortFilter() {
        mainpage.click(productSort);
    }
    public String getProductSortFilter() {
        return mainpage.textContent(productSort);
    }
    public void clickTwitterLink() {
        mainpage.click(twitterLinkSelector);
    }

    public String getTwitterLinkText() {
        return mainpage.textContent(twitterLinkSelector);
    }
}
