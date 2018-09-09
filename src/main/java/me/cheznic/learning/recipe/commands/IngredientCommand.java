package me.cheznic.learning.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private String id;
    private String recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}