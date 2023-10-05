package com.example.demovue.service.impl.product;

import com.example.demovue.model.Product;
import com.example.demovue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllList() {
        return productRepository.findAll();
    }
}
