package com.recipe.mangement.service;

import com.recipe.mangement.entity.Recipe;
import com.recipe.mangement.model.RecipeCreateUpdateRequest;

import java.util.List;

public interface RecipeService {
    
    public void createRecipe(RecipeCreateUpdateRequest recipeCreateUpdateRequest);
    public void remove(Integer id);
    public Recipe findById(Integer id);
    public List<Recipe> findAll();
    public Recipe updateRecipe(Integer recipeId, RecipeCreateUpdateRequest recipeCreateUpdateRequest);
    
    
}
