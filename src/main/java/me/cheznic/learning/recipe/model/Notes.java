package me.cheznic.learning.recipe.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Charles Nicoletti on 8/25/18
 */
@Getter
@Setter
@Document
public class Notes {

    @Id
    private String id;
    private Recipe recipe;
    private String recipeNotes;
}
