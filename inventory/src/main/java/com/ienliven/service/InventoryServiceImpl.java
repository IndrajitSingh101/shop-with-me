package com.ienliven.service;

import com.ienliven.data.Category;
import com.ienliven.data.Item;
import com.ienliven.repository.CategoryRepository;
import com.ienliven.repository.ItemRepository;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InventoryServiceImpl implements InventoryService {
    private static final Logger LOGGER = Logger.getLogger(InventoryServiceImpl.class);
    @Inject
    ItemRepository inventoryRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Override
    public void persistItemDetails(Item item) {
        LOGGER.info("persist item details");
        item.setSku(UUID.randomUUID().toString());
        inventoryRepository.persistItem(item);
    }

    @Override
    public List<Item> getItems() {
        return inventoryRepository.listAll();
    }

    @Override
    public List<Item> getItemsByCategory(String category) {
        LOGGER.info("get item by category");
        return inventoryRepository.findItemByCategory(category);
    }

    @Override
    public Item getItemBySKU(String sku) {
        LOGGER.info("get item by sku");
        return inventoryRepository.findItemBySKU(sku);
    }

    @Override
    public void addCategory(Category category) {
        LOGGER.info("add category");
        category.setCategoryID(UUID.randomUUID().toString());
        categoryRepository.persist(category);
    }

    @Override
    public List<Category> getCategories(){
        LOGGER.info("get categories");
        return categoryRepository.listAll();
    }

    @Override
    public void updateCategory(Category category){
        LOGGER.info("update category");
        categoryRepository.updateCategory(category);
    }
}
