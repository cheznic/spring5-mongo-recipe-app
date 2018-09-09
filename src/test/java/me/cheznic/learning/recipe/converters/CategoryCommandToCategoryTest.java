package me.cheznic.learning.recipe.converters;

import me.cheznic.learning.recipe.commands.CategoryCommand;
import me.cheznic.learning.recipe.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
public class CategoryCommandToCategoryTest {
    private static final String ID_VALUE = "1";
    private static final String DESCRIPTION = "description";
    private CategoryCommandToCategory conveter;

    @Before
    public void setUp() throws Exception {
        conveter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(conveter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(conveter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = conveter.convert(categoryCommand);

        //then
        assertEquals(categoryCommand.getId(), category.getId());
        assertEquals(categoryCommand.getDescription(), category.getDescription());
    }

}
