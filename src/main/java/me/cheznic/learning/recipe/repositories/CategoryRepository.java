package me.cheznic.learning.recipe.repositories;

import me.cheznic.learning.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Charles Nicoletti on 8/25/18
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
