package me.cheznic.learning.recipe.services;

import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.commands.UnitOfMeasureCommand;
import me.cheznic.learning.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import me.cheznic.learning.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository uOMRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand uOMToUomCommand;


    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository uOMRepository, UnitOfMeasureToUnitOfMeasureCommand uOMToUomCommand) {
        this.uOMRepository = uOMRepository;
        this.uOMToUomCommand = uOMToUomCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        log.debug("Listing all units of measure");

        return StreamSupport
                .stream(uOMRepository.findAll().spliterator(), false)
                .map(uOMToUomCommand::convert)
                .collect(Collectors.toSet());
    }
}
