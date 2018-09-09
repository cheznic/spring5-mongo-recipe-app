package me.cheznic.learning.recipe.converters;

import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import me.cheznic.learning.recipe.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {
    private static final String DESCRIPTION = "description";
    private static final String NUMERIC_STRING = "1";

    private UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(NUMERIC_STRING);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(NUMERIC_STRING, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}
