package me.cheznic.learning.recipe.controllers;

import me.cheznic.learning.recipe.commands.RecipeCommand;
import me.cheznic.learning.recipe.services.ImageService;
import me.cheznic.learning.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Charles Nicoletti on 9/3/18
 */
public class ImageControllerTest {

    @Mock
    ImageService imageService;

    @Mock
    RecipeService recipeService;

    private ImageController imageController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        imageController = new ImageController(imageService, recipeService);

        mockMvc = MockMvcBuilders.standaloneSetup(imageController)
                .setControllerAdvice(new ExceptionsController())
                .build();
    }

    @Test
    public void getImageForm() throws Exception {
        //given
        RecipeCommand command = new RecipeCommand();
        command.setId("1");

        when(recipeService.findCommandById(anyString())).thenReturn(command);

        //when
        mockMvc.perform(get("/recipe/1/image"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("recipe"));

        verify(recipeService, times(1)).findCommandById(anyString());

    }

    @Test
    public void handleImagePost() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "imagefile",
                "testing.txt",
                "text/plain",
                "Spring Framework Gru".getBytes());

        mockMvc.perform(multipart("/recipe/1/image").file(mockMultipartFile))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/recipe/1/show"));

        verify(imageService, times(1)).saveImageFile(anyString(), any());

    }

    @Test
    public void renderImageFromDB() throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId("1");

        String s = "fake image text";
        Byte[] bytes = new Byte[s.getBytes().length];

        int i = 0;

        for (byte b : s.getBytes())
            bytes[i++] = b;

        recipeCommand.setImage(bytes);

        when(recipeService.findCommandById(anyString())).thenReturn(recipeCommand);

        //when
        MockHttpServletResponse response = mockMvc.perform(get("/recipe/1/recipeimage"))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        byte[] responseBytes = response.getContentAsByteArray();

        assertEquals(s.getBytes().length, responseBytes.length);
    }

}
