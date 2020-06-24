package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
			
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {		
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}



	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasuerOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		System.out.println("Cat id is :" + categoryOptional.get().getId());
		System.out.println("UOM ID is :" + unitOfMeasuerOptional.get().getId());
		return "index";
	}

}
