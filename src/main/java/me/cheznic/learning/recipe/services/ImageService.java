package me.cheznic.learning.recipe.services;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * Created by Charles Nicoletti on 9/3/18
 */
public interface ImageService {

    Mono<Void> saveImageFile(String recipeId, MultipartFile file);
}
