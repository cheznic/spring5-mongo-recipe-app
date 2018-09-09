package me.cheznic.learning.recipe.converters;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import me.cheznic.learning.recipe.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Slf4j
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand uomc) {

        if (uomc == null)
            return null;

        log.trace("Converting UnitOfMeasureCommand to UnitOfMeasure");

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomc.getId());
        uom.setDescription(uomc.getDescription());
        return uom;
    }
}
