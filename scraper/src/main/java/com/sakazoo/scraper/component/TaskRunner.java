package com.sakazoo.scraper.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskRunner {

  private int i = 0;
  private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(cron = "${cron.cron1}")
  public void execute() {
    System.out.println("実行回数: " + ++i + ", 実行時間: " + sdf.format(new Date()));
  }
}
