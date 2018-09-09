package me.cheznic.learning.recipe.services;

import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.RecipeCommand;
import me.cheznic.learning.recipe.converters.RecipeCommandToRecipe;
import me.cheznic.learning.recipe.converters.RecipeToRecipeCommand;
import me.cheznic.learning.recipe.exceptions.NotFoundException;
import me.cheznic.learning.recipe.model.Recipe;
import me.cheznic.learning.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Charles Nicoletti on 8/30/18
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        log.debug(recipes.size() + " recipes returned.");
        return recipes;
    }

    public Recipe findById(String id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (!optionalRecipe.isPresent()) {
            String message = "Recipe with ID: " + id + " was not found.";
            log.warn(message);
            throw new NotFoundException(message);
        }

        return optionalRecipe.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(String id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(String idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
