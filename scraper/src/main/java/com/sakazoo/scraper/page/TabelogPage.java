package com.sakazoo.scraper.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TabelogPage {

  public SelenideElement count() {
    return $(".c-page-count");
  }

  public ElementsCollection results() {
    return $$(".list-rst");
  }

  public boolean hasNextPage(){
    return $(".c-pagination__arrow--next").exists();
  }

  public ElementsCollection nextResults() {
    $(".c-pagination__arrow--next").click();
    return results();
  }

}
