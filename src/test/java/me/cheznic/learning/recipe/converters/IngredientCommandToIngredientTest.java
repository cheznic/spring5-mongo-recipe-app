package me.cheznic.learning.recipe.converters;

import me.cheznic.learning.recipe.commands.IngredientCommand;
import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import me.cheznic.learning.recipe.model.Ingredient;
import me.cheznic.learning.recipe.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
public class IngredientCommandToIngredientTest {
    public static final Recipe RECIPE = new Recipe();
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String DESCRIPTION = "Cheeseburger";
    private static final String ID_VALUE = "1";
    private static final String UOM_ID = "2";

    private IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }
}
