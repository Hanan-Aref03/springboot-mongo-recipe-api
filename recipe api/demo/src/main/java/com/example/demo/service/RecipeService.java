package com.example.recipeapi.service;

import com.example.recipeapi.model.Recipe;
import com.example.recipeapi.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public Recipe createRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    public Recipe getRecipeById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public Recipe updateRecipe(String id, Recipe updatedRecipe) {
        Recipe recipe = getRecipeById(id);
        recipe.setTitle(updatedRecipe.getTitle());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setInstructions(updatedRecipe.getInstructions());
        recipe.setCookingTime(updatedRecipe.getCookingTime());
        recipe.setCategory(updatedRecipe.getCategory());
        return repository.save(recipe);
    }

    public void deleteRecipe(String id) {
        repository.deleteById(id);
    }
}
