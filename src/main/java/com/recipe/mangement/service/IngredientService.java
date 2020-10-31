package com.recipe.mangement.service;

import com.recipe.mangement.entity.Ingredient;
import com.recipe.mangement.model.IngredientCreateUpdateRequest;

import java.util.List;

public interface IngredientService {
    
    public void createIngredient(IngredientCreateUpdateRequest ingredientCreateUpdateRequest);
    public void remove(Integer id);
    public Ingredient findById(Integer id);
    public List<Ingredient> findAll();
    public Ingredient updateIngredient(Integer ingredientId, IngredientCreateUpdateRequest ingredientCreateUpdateRequest);
    
    
}
