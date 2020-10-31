package com.recipe.mangement.dao;

import com.recipe.mangement.entity.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class IngredientDao {
    
    private static final Logger log = LoggerFactory.getLogger(IngredientDao.class);
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param ingredient
     */
    public void persist(Ingredient ingredient){
        try{
            entityManager.persist(ingredient);
        }catch(Exception e){
            log.error("Error occured during save", e);
            throw e;
        }
    }

    /**
     *
     * @param ingredient
     */
    public void remove(Ingredient ingredient){
        try{
            entityManager.remove(ingredient);
        }catch(Exception e){
            log.error("Error occured during remove", e);
            throw e;
        }
    }
    
    /**
     * find address by id
     * @param id
     * @return
     */
    public Ingredient findById(Integer id){
        try{
            Ingredient ingredient = entityManager.find(Ingredient.class, id);
            return ingredient;
        }catch(Exception e){
            log.error("Error occured While fetching by id", e);
            throw e;
        }
    }
    
    /**
     * HQL usage
     * @return
     */
    public List<Ingredient> findAll(){
        try{
            Query query = entityManager.createQuery("select i from Ingredient i");
            List<Ingredient> ingredientList = query.getResultList();
            return ingredientList;
        }catch(Exception e){
            log.error("Error occured While fetching all address", e);
            throw e;
        }
    }

    /**
     *
     * @param ingredient
     */
    public Ingredient update(Ingredient ingredient){
        try{
            return entityManager.merge(ingredient);
        }catch(Exception e){
            log.error("Error occured during update", e);
            throw e;
        }
    }
}
