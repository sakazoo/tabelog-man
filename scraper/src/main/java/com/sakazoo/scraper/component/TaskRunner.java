package com.sakazoo.scraper.component;

import com.sakazoo.scraper.service.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskRunner {

  @Autowired
  private ScrapingService scrapingService;

  private int i = 0;
  private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

  //  @Scheduled(cron = "${cron.cron1}")
  @Scheduled(initialDelay=0, fixedDelay=60000)
  public void execute() {
    System.out.println("実行回数: " + ++i + ", 実行時間: " + sdf.format(new Date()));
    scrapingService.scrapeTabelog();
  }
}
