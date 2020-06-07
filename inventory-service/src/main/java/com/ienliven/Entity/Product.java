package com.ienliven.Entity;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "product")

public class Product extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @TextIndexed
    private String category;
    @TextIndexed
    private String productName;

}