package me.cheznic.learning.recipe.converters;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.IngredientCommand;
import me.cheznic.learning.recipe.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Slf4j
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {

        if (ingredientCommand == null)
            return null;

        log.trace("converting to Ingredient from IngredientCommand");

        final Ingredient ingredient = new Ingredient();
        ingredient.setDescription(ingredientCommand.getDescription());
        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setUom(uomConverter.convert(ingredientCommand.getUom()));
        ingredient.setId(ingredientCommand.getId());
        return ingredient;
    }
}
