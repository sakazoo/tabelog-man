package com.sakazoo.scraper.page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class TabelogPage {

  public ElementsCollection results() {
    return $$(".list-rst");
  }

}
