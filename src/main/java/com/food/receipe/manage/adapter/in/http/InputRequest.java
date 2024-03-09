package com.food.receipe.manage.adapter.in.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputRequest {

    private String receipeId;

    private String dish;

    private String ingredient;

    private String servings;

    private String instruction;

    private String name;

    private String userId;

}

