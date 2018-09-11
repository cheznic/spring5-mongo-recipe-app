package me.cheznic.learning.recipe.repositories.reactive;

import me.cheznic.learning.recipe.model.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Charles Nicoletti on 9/10/18
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe , String> {
}
