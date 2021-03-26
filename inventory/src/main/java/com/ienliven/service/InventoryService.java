package com.ienliven.service;

import com.ienliven.data.Category;
import com.ienliven.data.Item;
import java.util.List;

public interface InventoryService {
    public void persistItemDetails(Item item);

    public List<Item> getItems();

    public List<Item> getItemsByCategory(String category);

    public Item getItemBySKU(String sku);

    public void addCategory(Category category);

    public List<Category> getCategories();

    public void updateCategory(Category category);
}
