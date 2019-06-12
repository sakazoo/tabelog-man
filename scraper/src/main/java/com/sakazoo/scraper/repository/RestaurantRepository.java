package com.sakazoo.scraper.repository;

import com.sakazoo.scraper.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
