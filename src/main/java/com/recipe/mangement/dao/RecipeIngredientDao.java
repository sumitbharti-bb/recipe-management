package com.recipe.mangement.dao;

import com.recipe.mangement.entity.RecipeIngredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RecipeIngredientDao {
    
    private static final Logger log = LoggerFactory.getLogger(RecipeIngredientDao.class);
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param recipeIngredient
     */
    public void persist(RecipeIngredient recipeIngredient){
        try{
            entityManager.persist(recipeIngredient);
        }catch(Exception e){
            log.error("Error occured during save", e);
            throw e;
        }
    }

    /**
     *
     * @param recipeIngredient
     */
    public void remove(RecipeIngredient recipeIngredient){
        try{
            entityManager.remove(recipeIngredient);
        }catch(Exception e){
            log.error("Error occured during remove", e);
            throw e;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public RecipeIngredient findById(Integer id){
        try{
            RecipeIngredient recipeIngredient = entityManager.find(RecipeIngredient.class, id);
            return recipeIngredient;
        }catch(Exception e){
            log.error("Error occured While fetching by id", e);
            throw e;
        }
    }
    
    /**
     * HQL usage
     * @return
     */
    public List<RecipeIngredient> findAll(){
        try{
            Query query = entityManager.createQuery("select r from RecipeIngredient r");
            List<RecipeIngredient> recipeIngredientList = query.getResultList();
            return recipeIngredientList;
        }catch(Exception e){
            log.error("Error occured While fetching all address", e);
            throw e;
        }
    }

    /**
     *
     * @param recipeIngredient
     */
    public RecipeIngredient update(RecipeIngredient recipeIngredient){
        try{
            return entityManager.merge(recipeIngredient);
        }catch(Exception e){
            log.error("Error occured during update", e);
            throw e;
        }
    }
}
