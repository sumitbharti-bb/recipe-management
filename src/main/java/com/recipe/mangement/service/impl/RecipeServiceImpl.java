package com.recipe.mangement.service.impl;

import com.recipe.mangement.dao.RecipeDao;
import com.recipe.mangement.entity.Recipe;
import com.recipe.mangement.model.RecipeCreateUpdateRequest;
import com.recipe.mangement.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public void createRecipe(RecipeCreateUpdateRequest recipeCreateUpdateRequest) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeCreateUpdateRequest.getName());
        recipe.setDescription(recipeCreateUpdateRequest.getDescription());
        recipe.setImageUrl(recipeCreateUpdateRequest.getImageUrl());
        recipeDao.persist(recipe);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        Recipe ingredient = recipeDao.findById(id);
        recipeDao.remove(ingredient);
    }
    
    @Override
    @Transactional
    public Recipe findById(Integer id) {
        Recipe recipe =  recipeDao.findById(id);
        return recipe;
    }
    
    @Override
    @Transactional
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    @Override
    public Recipe updateRecipe(Integer recipeId, RecipeCreateUpdateRequest recipeCreateUpdateRequest) {
        Recipe recipe =  recipeDao.findById(recipeId);
        recipe.setName(recipeCreateUpdateRequest.getName());
        recipe.setDescription(recipeCreateUpdateRequest.getDescription());
        recipe.setImageUrl(recipeCreateUpdateRequest.getImageUrl());
        return recipeDao.update(recipe);
    }
}
