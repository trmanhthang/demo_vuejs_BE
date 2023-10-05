package com.example.demovue.service.impl.product;

import com.example.demovue.model.Product;
import com.example.demovue.service.ICoreService;

import java.util.List;

public interface IProductService extends ICoreService<Product> {
    List<Product> findAllList();
}
