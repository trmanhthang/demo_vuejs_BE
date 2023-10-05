package com.example.demovue.service.impl.category;

import com.example.demovue.model.Category;
import com.example.demovue.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllPage (Pageable pageable) {
        return null;
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllList() {
        return categoryRepository.findAll();
    }
}
