package shopProject.Shop.service;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import shopProject.Shop.entity.CategoryEntity;
import shopProject.Shop.io.CategoryRequest;
import shopProject.Shop.io.CategoryResponse;
import shopProject.Shop.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor for dependency injection
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void delete (String categoryId) {
    CategoryEntity existingCategory=	categoryRepository.findByCategoryId(categoryId)
    	.orElseThrow(()-> new RuntimeException("Cateogry Not Found : "+ categoryId));
    categoryRepository.delete(existingCategory);
    	
    }
    @Override
    public List<CategoryResponse> read(){
    	
     return categoryRepository.findAll()
      .stream()
      .map(categoryEntity -> convertToResponse(categoryEntity))
      .collect(Collectors.toList());
     }
    
    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCategory = convertToEntity(request);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        CategoryResponse response = new CategoryResponse();
        response.setCategoryId(newCategory.getCategoryId());
        response.setName(newCategory.getName());
        response.setDescription(newCategory.getDescription());
        response.setBgColor(newCategory.getBgColor());
        response.setImgUrl(newCategory.getImgUrl());
        response.setCreatedAt(newCategory.getCreatedAt());
        response.setUpdatedAt(newCategory.getUpdatedAt());
        return response;
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryId(UUID.randomUUID().toString());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setBgColor(request.getBgColor());
        entity.setImgUrl(request.getImgUrl());
        return entity;
    }
}
