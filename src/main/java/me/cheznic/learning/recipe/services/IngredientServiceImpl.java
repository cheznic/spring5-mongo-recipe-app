package me.cheznic.learning.recipe.services;

import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.IngredientCommand;
import me.cheznic.learning.recipe.converters.IngredientCommandToIngredient;
import me.cheznic.learning.recipe.converters.IngredientToIngredientCommand;
import me.cheznic.learning.recipe.model.Ingredient;
import me.cheznic.learning.recipe.model.Recipe;
import me.cheznic.learning.recipe.repositories.RecipeRepository;
import me.cheznic.learning.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(
            IngredientToIngredientCommand ingredientToIngredientCommand,
            IngredientCommandToIngredient ingredientCommandToIngredient,
            RecipeRepository recipeRepository,
            UnitOfMeasureRepository unitOfMeasureRepository) {

        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        IngredientCommand ingredientCommand = ingredientCommandOptional.get();
        ingredientCommand.setRecipeId(recipeId);

        return ingredientCommand;
    }

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(ingredientCommand.getRecipeId());

        if (!recipeOptional.isPresent()) {

            //todo toss error if not found!
            log.error("Recipe not found for id: " + ingredientCommand.getRecipeId());
            return new IngredientCommand();
        }

        Recipe recipe = recipeOptional.get();

        Optional<Ingredient> ingredientOptional = recipe
                .getIngredients()
                .stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientCommand.getId()))
                .findFirst();

        if (ingredientOptional.isPresent()) {
            Ingredient ingredientFound = ingredientOptional.get();
            ingredientFound.setDescription(ingredientCommand.getDescription());
            ingredientFound.setAmount(ingredientCommand.getAmount());
            ingredientFound.setUom(unitOfMeasureRepository
                    .findById(ingredientCommand.getUom().getId())
                    .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
        } else {
            //add new Ingredient
            Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
            recipe.addIngredient(ingredient);
        }

        Recipe savedRecipe = recipeRepository.save(recipe);

        Optional<Ingredient> savedOptionalIngredient = savedRecipe
                .getIngredients()
                .stream()
                .filter(recipeIngredients -> recipeIngredients.getId().equals(ingredientCommand.getId()))
                .findFirst();

        if (!savedOptionalIngredient.isPresent()) {
            savedOptionalIngredient = savedRecipe
                    .getIngredients()
                    .stream()
                    .filter(recipeIngredients -> recipeIngredients.getDescription().equals(ingredientCommand.getDescription()))
                    .filter(recipeIngredients -> recipeIngredients.getAmount().equals(ingredientCommand.getAmount()))
                    .filter(recipeIngredients -> recipeIngredients.getUom().getId().equals(ingredientCommand.getUom().getId()))
                    .findFirst();
        }

        //todo check for fail

        //enhance with id value
        IngredientCommand ingredientCommandSaved = ingredientToIngredientCommand.convert(savedOptionalIngredient.get());
        ingredientCommandSaved.setRecipeId(recipe.getId());

        return ingredientCommandSaved;
    }

    @Override
    public void deleteByRecipeIdAndIngredientId(String recipeId, String idToDelete) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);

        if (!optionalRecipe.isPresent()) {
            log.debug("Did not find recipe with ingredient to delete. Recipe id: " + recipeId + " Ingredient id: " + idToDelete);
            return; // todo throw exception
        }

        Recipe recipe = optionalRecipe.get();

        Optional<Ingredient> optionalIngredient = recipe
                .getIngredients()
                .stream()
                .filter(ingredient -> ingredient.getId().equals(idToDelete))
                .findFirst();

        //recipe.getIngredients().removeIf(ingredient -> ingredient.getId().equals(idToDelete));

        if (!optionalIngredient.isPresent()) {
            log.debug("Did not find ingredient to delete with id: " + idToDelete);
            return; //todo throw exception
        }

        recipe.getIngredients().remove(optionalIngredient.get());
        recipeRepository.save(recipe);

        log.debug("Deleting ingredient with id: " + idToDelete + "from recipe: " + recipeId);
    }
}