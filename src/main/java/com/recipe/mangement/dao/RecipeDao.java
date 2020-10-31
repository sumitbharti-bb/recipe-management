package com.recipe.mangement.dao;

import com.recipe.mangement.entity.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RecipeDao {
    
    private static final Logger log = LoggerFactory.getLogger(RecipeDao.class);
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param recipe
     */
    public void persist(Recipe recipe){
        try{
            entityManager.persist(recipe);
        }catch(Exception e){
            log.error("Error occured during save", e);
            throw e;
        }
    }

    /**
     *
     * @param recipe
     */
    public void remove(Recipe recipe){
        try{
            entityManager.remove(recipe);
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
    public Recipe findById(Integer id){
        try{
            Recipe recipe = entityManager.find(Recipe.class, id);
            return recipe;
        }catch(Exception e){
            log.error("Error occured While fetching by id", e);
            throw e;
        }
    }
    
    /**
     * HQL usage
     * @return
     */
    public List<Recipe> findAll(){
        try{
            Query query = entityManager.createQuery("select r from Recipe r");
            List<Recipe> recipeList = query.getResultList();
            return recipeList;
        }catch(Exception e){
            log.error("Error occured While fetching all address", e);
            throw e;
        }
    }

    /**
     *
     * @param recipe
     */
    public Recipe update(Recipe recipe){
        try{
            return entityManager.merge(recipe);
        }catch(Exception e){
            log.error("Error occured during update", e);
            throw e;
        }
    }
}
