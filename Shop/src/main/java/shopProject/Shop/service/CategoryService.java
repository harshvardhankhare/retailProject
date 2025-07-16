package shopProject.Shop.service;

import java.util.List;

import shopProject.Shop.io.CategoryRequest;
import shopProject.Shop.io.CategoryResponse;

public interface CategoryService {
	 CategoryResponse add(CategoryRequest request);
	 List<CategoryResponse> read();
	 void delete(String categoryId);
}
