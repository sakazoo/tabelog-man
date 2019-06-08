package com.sakazoo.scraper.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 店舗情報
 * 
 * @author sakazoo
 */
public class Restaurant {

  // 連番
  private int id;

  // 店名
  private String name;

  // 店舗URL
  private String url;

  // 最寄り駅
  private String station;

  // スター評価
  private Double score;

  // レビュー件数
  private int reviews;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public int getReviews() {
    return reviews;
  }

  public void setReviews(int reviews) {
    this.reviews = reviews;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getStation() {
    return station;
  }

  public void setStation(String station) {
    this.station = station;
  }

  public String toString(){
    return ReflectionToStringBuilder.toString(this  );
  }
}
