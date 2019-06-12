package com.sakazoo.scraper.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * 店舗情報
 * 
 * @author sakazoo
 */
@Entity
@Table(name="restaurant")
public class Restaurant {

  // 連番
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 店名
  @Column
  private String name;

  // 店舗URL
  @Column
  private String url;

  // 最寄り駅
  @Column
  private String station;

  // スター評価
  @Column
  private Double score;

  // レビュー件数
  @Column
  private int reviews;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
