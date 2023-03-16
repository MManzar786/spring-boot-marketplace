package app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dto.CategoryResponse;
import app.model.Category;
import app.repository.CategoryRepository;
import app.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	@Override
	public CategoryResponse findAll() {
		List<Category> categories = this.categoryRepository.findAll();
		return CategoryResponse.builder().categories(categories).build();
	}

}

