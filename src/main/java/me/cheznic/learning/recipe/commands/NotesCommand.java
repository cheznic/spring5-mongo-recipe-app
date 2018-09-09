package me.cheznic.learning.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private String id;
    private String recipeNotes;

}