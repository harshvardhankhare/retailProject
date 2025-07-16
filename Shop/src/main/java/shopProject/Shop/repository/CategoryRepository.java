package shopProject.Shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopProject.Shop.entity.CategoryEntity;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

	Optional<CategoryEntity> findByCategoryId(String categoryId);
}
