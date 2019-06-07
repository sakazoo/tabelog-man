package com.sakazoo.scraper.service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Service
public class ScrapingService {

  @PostConstruct
  public void init() {
    // ChromeHeadlessを有効にする
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.headless = true;
    Configuration.browserSize = "1024x768";
  }

  public void scrapeTabelog(){
    open("https://tabelog.com/tokyo/rstLst/gyouza/");
    ElementsCollection elems = $$(".list-rst");
    for (SelenideElement elem :elems ) {
      System.out.println(elem.find(By.tagName("a")));
    }
  }
}
