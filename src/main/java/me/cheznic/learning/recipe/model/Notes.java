package me.cheznic.learning.recipe.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Charles Nicoletti on 8/25/18
 */
@Getter
@Setter
public class Notes {

    private String id;
    private Recipe recipe;
    private String recipeNotes;
}
