package com.ienliven.data;

import com.ienliven.dto.CategoryDTO;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.*;

@MongoEntity(collection = "Category")
@Data
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String categoryID;
    private String categoryName;
    private String categoryDescription;

    public Category convertFromDTO(CategoryDTO categoryDTO){
        return Category.builder().categoryName(categoryDTO.getCategoryName()).categoryDescription(categoryDTO.getCategoryDescription()).build();
    }
}
