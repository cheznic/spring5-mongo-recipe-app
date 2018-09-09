package me.cheznic.learning.recipe.converters;

import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import me.cheznic.learning.recipe.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {
    private static final String DESCRIPTION = "description";
    private static final String NUMERIC_STRING = "1";

    private UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(NUMERIC_STRING);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommand uomc = converter.convert(uom);

        //then
        assertEquals(NUMERIC_STRING, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }
}
