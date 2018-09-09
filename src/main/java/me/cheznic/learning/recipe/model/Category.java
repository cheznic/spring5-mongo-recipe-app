package me.cheznic.learning.recipe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Charles Nicoletti on 8/25/18
 */
@Getter
@Setter
public class Category {

    private String id;
    private String description;
    private Set<Recipe> recipes;

}
