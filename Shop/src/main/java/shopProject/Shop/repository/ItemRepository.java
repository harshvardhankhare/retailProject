package shopProject.Shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopProject.Shop.entity.ItemEntity;

import java.util.Optional;


public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    Optional<ItemEntity> findByItemId(String id);

    int countByCategoryId(Long id);
}
