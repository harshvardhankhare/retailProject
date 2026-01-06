package shopProject.Shop.service;

import org.springframework.web.multipart.MultipartFile;
import shopProject.Shop.io.ItemRequest;
import shopProject.Shop.io.ItemResponse;

import java.util.List;

public interface ItemService {
    ItemResponse add(ItemRequest request, MultipartFile file);

    List<ItemResponse> fetchItems();

    void deleteIem(String itemId);
}
