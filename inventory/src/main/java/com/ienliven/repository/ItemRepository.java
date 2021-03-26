package com.ienliven.repository;

import com.ienliven.data.Item;
import com.ienliven.service.InventoryServiceImpl;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ItemRepository implements PanacheMongoRepository<Item> {
    private static final Logger LOGGER = Logger.getLogger(ItemRepository.class);
    public void persistItem(Item item) {
        persist(item);
    }

    public void updateItem(Item item){
        update(item);
    }

    public List<Item> findItemByCategory(String category) {
        return list("categoryID", category);
    }

    public Item findItemBySKU(String sku){
        return find("sku",sku).firstResult();
    }
}
