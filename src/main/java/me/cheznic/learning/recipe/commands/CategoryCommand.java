package me.cheznic.learning.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Charles Nicoletti on 9/1/18
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private String id;
    private String description;
}