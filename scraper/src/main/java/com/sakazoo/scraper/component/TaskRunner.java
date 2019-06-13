package com.sakazoo.scraper.component;

import com.sakazoo.scraper.service.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskRunner {

  @Autowired
  private ScrapingService scrapingService;

  private int i = 0;
  private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");

  @Scheduled(cron = "${cron.cron1}")
  public void execute() {
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("データ収集開始: " + dateTime.format(f));
    scrapingService.scrapeTabelog();
  }
}
