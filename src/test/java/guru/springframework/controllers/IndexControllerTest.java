package guru.springframework.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;

class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;

	IndexController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(recipeService);
	}

	@Test
	void testGetIndexPage() {
		
		// given 
		Set<Recipe> recipes = new HashSet<>();
		
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		String viewName = controller.getIndexPage(model);
		assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInCOntroller = argumentCaptor.getValue();
        assertEquals(2, setInCOntroller.size());
		
	}

}
