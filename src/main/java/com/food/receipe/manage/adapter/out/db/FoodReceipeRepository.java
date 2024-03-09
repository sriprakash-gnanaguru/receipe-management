package com.food.receipe.manage.adapter.out.db;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodReceipeRepository extends JpaRepository<FoodReceipe,String> {
}
