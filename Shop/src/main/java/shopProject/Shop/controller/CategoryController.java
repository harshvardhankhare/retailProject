package shopProject.Shop.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import shopProject.Shop.io.CategoryRequest;
import shopProject.Shop.io.CategoryResponse;
import shopProject.Shop.service.CategoryService;



@RestController
//@RequestMapping("/categories")
//@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    // ✅ Add constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/admin/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        return categoryService.add(request);
    }
@GetMapping
    public List<CategoryResponse> fetchCategories(){
    	return categoryService.read();
    }

    @DeleteMapping("/admin/categories/{categoryId}")
public void remove(@PathVariable String categoryId) {
	
    	try {
    		categoryService.delete(categoryId);
    	}
    	catch(Exception e){
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
    	}
}
    @GetMapping("/test")
    public String test() {
        return "Category controller is working";
    }
}

