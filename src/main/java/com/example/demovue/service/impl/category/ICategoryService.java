package com.example.demovue.service.impl.category;

import com.example.demovue.model.Category;
import com.example.demovue.service.ICoreService;

import java.util.List;

public interface ICategoryService extends ICoreService<Category> {
    List<Category> findAllList ();
}
