package me.cheznic.learning.recipe.converters;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.CategoryCommand;
import me.cheznic.learning.recipe.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Slf4j
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category category) {

        if (category == null)
            return null;

        log.trace("converting to CategoryCommand from Category");

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(category.getId());
        categoryCommand.setDescription(category.getDescription());

        return categoryCommand;
    }
}
