package com.food.receipe.manage.adapter.out.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="FOOD_RECEIPE_MANAGEMENT")
public class FoodReceipe {
    @Column(name="RECEIPE_ID")
    @Id
    private String id;

    @Column(name="NAME")
    private String name;

    @Column(name="DISH")
    private String dish;

    @Column(name="NO_OF_SERVINGS")
    private Integer servings;

    @Column(name="INGREDIENT")
    private String ingredient;

    @Column(name="INSTRUCTION")
    private String instruction;

    @Column(name="LAST_UPDATED_TIME")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate lastUpdatedTime;

    @Column(name="LAST_UPDATED_BY")
    private String lastUpdatedBy;


}
