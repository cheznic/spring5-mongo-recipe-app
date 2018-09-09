package me.cheznic.learning.recipe.converters;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.NotesCommand;
import me.cheznic.learning.recipe.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Slf4j
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {

        if(notesCommand == null)
            return null;

        log.trace("Converting NotesCommand to Notes");

        final Notes notes = new Notes();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes;
    }
}
