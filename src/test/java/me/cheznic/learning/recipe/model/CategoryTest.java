package me.cheznic.learning.recipe.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        String idValue = "448888888";

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {

    }

    @Test
    public void getRecipes() {

    }
}