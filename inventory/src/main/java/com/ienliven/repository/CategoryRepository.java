package com.ienliven.repository;

import com.ienliven.data.Category;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheMongoRepository<Category> {
 public void persistCategory(Category category){
     persist(category);
    }
    public void updateCategory(Category category){
     update(category);
    }
}
