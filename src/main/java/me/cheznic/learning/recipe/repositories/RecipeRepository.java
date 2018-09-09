package me.cheznic.learning.recipe.repositories;

import me.cheznic.learning.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Charles Nicoletti on 8/25/18
 */
public interface RecipeRepository extends CrudRepository<Recipe, String> {


}
