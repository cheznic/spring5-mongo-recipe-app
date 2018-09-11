package me.cheznic.learning.recipe.repositories.reactive;

import me.cheznic.learning.recipe.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by Charles Nicoletti on 9/10/18
 */
public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {

    Mono<Category> findFirstByDescription(String description);
}
