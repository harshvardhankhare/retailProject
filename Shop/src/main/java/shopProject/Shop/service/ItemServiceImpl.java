package shopProject.Shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shopProject.Shop.io.ItemRequest;
import shopProject.Shop.io.ItemResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final FileUploadService fileUploadService;

    @Override
    public ItemResponse add(ItemRequest request, MultipartFile file) {
        return null;
    }

    @Override
    public List<ItemResponse> fetchItems() {
        return List.of();
    }

    @Override
    public void deleteIem(String itemId) {

    }
}
