package com.sakazoo.scraper.service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.sakazoo.scraper.entity.Restaurant;
import com.sakazoo.scraper.page.TabelogPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@Service
public class ScrapingService {

  private final static Logger logger = LoggerFactory.getLogger(ScrapingService.class);

  @PostConstruct
  public void init() {
    // ChromeHeadlessを有効にする
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.headless = true;
    Configuration.browserSize = "1024x768";
  }

  public void scrapeTabelog(){
    TabelogPage tabelogPage = open("https://tabelog.com/tokyo/rstLst/gyouza/59/", TabelogPage.class);
    ElementsCollection elements = tabelogPage.results();
    List<Restaurant> restaurantList = new ArrayList<>();
    logger.info(tabelogPage.count().innerText());
    // 表示画面1ページ内に掲載されている全ての店情報を取得
    for (SelenideElement element :elements ) {
      Restaurant restaurant = createRestaurant(element);
      restaurantList.add(restaurant);
    }
    while(tabelogPage.hasNextPage()){
      elements = tabelogPage.nextResults();
      logger.info(tabelogPage.count().innerText());
      for (SelenideElement element :elements ) {
        Restaurant restaurant = createRestaurant(element);
        restaurantList.add(restaurant);
      }
    }
  }

  private Restaurant createRestaurant(SelenideElement element){
    Restaurant restaurant = new Restaurant();
    restaurant.setName(element.find(By.tagName("a")).innerText());
    restaurant.setUrl(element.find(By.tagName("a")).getAttribute("href"));
    String station = element.find(By.className("list-rst__area-genre")).innerText().split("駅")[0];
    restaurant.setStation(station);
    // 評価0件の場合はHTML要素が取得できないため条件分岐
    if(element.find(By.className("c-rating__val--strong")).exists()){
      String scoreStr = element.find(By.className("c-rating__val--strong")).innerText();
      Double score = Double.parseDouble(scoreStr);
      restaurant.setScore(score);
      String reviewsStr = element.find(By.className("list-rst__rvw-count-num")).innerText();
      int reviews = Integer.parseInt(reviewsStr);
      restaurant.setReviews(reviews);
    } else{
      restaurant.setScore(null);
      restaurant.setReviews(0);
    }
    logger.info(restaurant.toString());
    return restaurant;
  }
}
