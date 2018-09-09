package me.cheznic.learning.recipe.services;

import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
