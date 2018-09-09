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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {

        if (notes == null)
            return null;

        log.trace("Converting Notes to NotesCommand");

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        return notesCommand;
    }
}