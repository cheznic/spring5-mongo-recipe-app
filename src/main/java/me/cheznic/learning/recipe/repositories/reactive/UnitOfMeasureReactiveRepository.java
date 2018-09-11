package me.cheznic.learning.recipe.repositories.reactive;

import me.cheznic.learning.recipe.model.UnitOfMeasure;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by Charles Nicoletti on 9/10/18
 */
public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {

    Mono<UnitOfMeasure> findFirstByDescription(String name);
}
