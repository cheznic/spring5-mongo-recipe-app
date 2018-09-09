package me.cheznic.learning.recipe.services;

public class ImageServiceImplTest {
//
//    @Mock
//    RecipeRepository recipeRepository;
//
//    private ImageService imageService;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
//        imageService = new ImageServiceImpl(recipeRepository);
//    }
//
//    @Test
//    public void saveImageFile() throws Exception {
//        //given
//        String id = "1";
//        MultipartFile multipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain",
//                "Spring Framework Guru".getBytes());
//
//        Recipe recipe = new Recipe();
//        recipe.setId(id);
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//
//        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//
//        ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
//
//        //when
//        imageService.saveImageFile(id, multipartFile);
//
//        //then
//        verify(recipeRepository, times(1)).save(argumentCaptor.capture());
//        Recipe savedRecipe = argumentCaptor.getValue();
//        assertEquals(multipartFile.getBytes().length, savedRecipe.getImage().length);
//    }

}