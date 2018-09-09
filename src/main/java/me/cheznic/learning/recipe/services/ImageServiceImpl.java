package me.cheznic.learning.recipe.services;

import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.model.Recipe;
import me.cheznic.learning.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Charles Nicoletti on 9/3/18
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl( RecipeRepository recipeService) {

        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(String recipeId, MultipartFile file) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);

        if (!optionalRecipe.isPresent()) {
            log.error("did not find recipe with id: " + recipeId);
            // todo throw exception if recipe not found
        }

        Recipe recipe = optionalRecipe.get();

        try {
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
