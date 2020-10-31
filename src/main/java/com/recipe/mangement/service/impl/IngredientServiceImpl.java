package com.recipe.mangement.service.impl;

import com.recipe.mangement.dao.IngredientDao;
import com.recipe.mangement.entity.Ingredient;
import com.recipe.mangement.model.IngredientCreateUpdateRequest;
import com.recipe.mangement.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    
    @Autowired
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public void createIngredient(IngredientCreateUpdateRequest ingredientCreateUpdateRequest) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientCreateUpdateRequest.getName());
        ingredientDao.persist(ingredient);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        Ingredient ingredient = ingredientDao.findById(id);
        ingredientDao.remove(ingredient);
    }
    
    @Override
    @Transactional
    public Ingredient findById(Integer id) {
        Ingredient ingredient =  ingredientDao.findById(id);
        return ingredient;
    }
    
    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return ingredientDao.findAll();
    }

    @Override
    public Ingredient updateIngredient(Integer ingredientId, IngredientCreateUpdateRequest ingredientCreateUpdateRequest) {
        Ingredient ingredient =  ingredientDao.findById(ingredientId);
        ingredient.setName(ingredientCreateUpdateRequest.getName());
        return ingredientDao.update(ingredient);
    }
}
