package com.example.demovue.controller;

import com.example.demovue.model.Category;
import com.example.demovue.model.Product;
import com.example.demovue.service.impl.category.ICategoryService;
import com.example.demovue.service.impl.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/default")
public class DefaultController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    //    api sản phẩm
    @PostMapping("/product/save")
    public  ResponseEntity<Void> save (@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/product/all")
    public ResponseEntity<Page<Product>> getAll (@PageableDefault(size = 5) Pageable pageable) {
        Page<Product> products = productService.findAllPage(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/all-list")
    public ResponseEntity<List<Product>> getAllProduct () {
        List<Product> products = productService.findAllList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/detail/id={id}")
    public ResponseEntity<Product> getOne (@PathVariable("id") Long id) {
        Product product = productService.findOne(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/id={id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/product/edit")
    public ResponseEntity<Void> edit (@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

//    api danh mục
    @PostMapping("/category/save")
    public ResponseEntity<Void> save (@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/category/all")
    public ResponseEntity<List<Category>> getAll () {
        List<Category> categories = categoryService.findAllList();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping("/category/delete/id={id}")
    public ResponseEntity<Void> deleteCategory (@PathVariable("id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category/edit")
    public ResponseEntity<Void> edit (@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
