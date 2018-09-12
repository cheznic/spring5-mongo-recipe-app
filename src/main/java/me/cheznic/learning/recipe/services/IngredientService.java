package me.cheznic.learning.recipe.services;

import me.cheznic.learning.recipe.commands.IngredientCommand;
import reactor.core.publisher.Mono;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
public interface IngredientService {

    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand ingredientCommand);

    Mono<Void> deleteByRecipeIdAndIngredientId(String recipeId, String idToDelete);
}
