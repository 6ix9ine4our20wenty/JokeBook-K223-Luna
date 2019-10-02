package ch.liluna.jokebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.liluna.jokebook.domain.Category;
import ch.liluna.jokebook.repository.CategoryRepository;

@Service
public class CategoryService {
	 private CategoryRepository categoryRepository;

	    public CategoryService(CategoryRepository categoryRepository) {
	        this.categoryRepository = categoryRepository;
	    }

	    public List<Category> findAll() {
	        return categoryRepository.findAll();
	    }

	    public Optional<Category> findUserById(long id) {
	        return categoryRepository.findById(id);
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.saveAndFlush(category);
	    }

	    public void deleteCategoryById(long id) {
	        if (categoryRepository.existsById(id)) {
	            categoryRepository.deleteById(id);
	        }
	    }

	

}
