package me.cheznic.learning.recipe.services;

import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
