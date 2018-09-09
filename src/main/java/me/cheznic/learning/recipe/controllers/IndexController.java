package me.cheznic.learning.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import me.cheznic.learning.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Charles Nicoletti on 8/24/18
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index", "index.html"})
    public String getIndexPage (Model model) {
        log.debug("Getting index page.");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
