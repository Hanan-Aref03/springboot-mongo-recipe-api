package com.example.recipeapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    private String id;

    @NotBlank(message = "Title is required")
    private String title;

    private List<@NotBlank(message = "Ingredient can't be blank") String> ingredients;

    @NotBlank(message = "Instructions are required")
    private String instructions;

    private int cookingTime; // in minutes

    private String category;
}
