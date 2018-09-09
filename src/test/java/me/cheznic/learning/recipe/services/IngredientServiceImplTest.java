package me.cheznic.learning.recipe.services;

/**
 * Created by Charles Nicoletti on 9/2/18
 */
public class IngredientServiceImplTest {
//    private final IngredientToIngredientCommand ingredientToIngredientCommand;
//    private final IngredientCommandToIngredient ingredientCommandToIngredient;
//
//    @Mock
//    RecipeRepository recipeRepository;
//
//    @Mock
//    UnitOfMeasureRepository unitOfMeasureRepository;
//
//    //init converters
//    public IngredientServiceImplTest() {
//        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
//        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
//    }
//
//    private IngredientService ingredientService;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient, recipeRepository, unitOfMeasureRepository);
//    }
//
//    @Test
//    public void findByRecipeIdAndId() throws Exception {
//    }
//
//    @Test
//    public void findByRecipeIdAndRecipeIdHappyPath() throws Exception {
//        //given
//        Recipe recipe = new Recipe();
//        recipe.setId("1");
//
//        Ingredient ingredient1 = new Ingredient();
//        ingredient1.setId("5");
//
//        Ingredient ingredient2 = new Ingredient();
//        ingredient2.setId("6");
//
//        Ingredient ingredient3 = new Ingredient();
//        ingredient3.setId("7");
//
//        recipe.addIngredient(ingredient1);
//        recipe.addIngredient(ingredient2);
//        recipe.addIngredient(ingredient3);
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//
//        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
//
//        //then
//        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 5L);
//
//        //when
//        assertEquals("5", ingredientCommand.getId());
//        assertEquals("1", ingredientCommand.getRecipeId());
//        verify(recipeRepository, times(1)).findById(anyString());
//    }
//
//
//    @Test
//    public void testSaveRecipeCommand() throws Exception {
//        //given
//        IngredientCommand command = new IngredientCommand();
//        command.setId("3");
//        command.setRecipeId("2");
//
//        Optional<Recipe> recipeOptional = Optional.of(new Recipe());
//
//        Recipe savedRecipe = new Recipe();
//        savedRecipe.addIngredient(new Ingredient());
//        savedRecipe.getIngredients().iterator().next().setId("3");
//
//        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);
//        when(recipeRepository.save(any())).thenReturn(savedRecipe);
//
//        //when
//        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);
//
//        //then
//        assertEquals("3", savedCommand.getId());
//        verify(recipeRepository, times(1)).findById(anyString());
//        verify(recipeRepository, times(1)).save(any(Recipe.class));
//
//    }
//
//    @Test
//    public void testDeleteById() throws Exception {
//        Recipe recipe = new Recipe();
//        Ingredient ingredient = new Ingredient();
//        ingredient.setId("3");
//        recipe.addIngredient(ingredient);
//        ingredient.setRecipe(recipe);
//        Optional<Recipe> optionalRecipe = Optional.of(recipe);
//
//        when(recipeRepository.findById(anyString())).thenReturn(optionalRecipe);
//
//        //when
//        ingredientService.deleteByRecipeIdAndIngredientId("1", "3");
//
//        //then
//        verify(recipeRepository, times(1)).findById(anyString());
//        verify(recipeRepository, times(1)).save(any(Recipe.class));
//    }

}