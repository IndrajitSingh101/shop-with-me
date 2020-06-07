package com.ienliven.controller;

import com.ienliven.model.Product;

import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface ProductConsumer{
void updateProductInventory(Product p,Product item);
}
