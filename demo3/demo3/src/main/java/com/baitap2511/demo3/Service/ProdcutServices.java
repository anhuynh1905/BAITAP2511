package com.baitap2511.demo3.Service;

import com.baitap2511.demo3.entity.Products;

import java.util.List;

public interface ProdcutServices {
    void delete(Long id);
    Products get(Long id);
    Products save(Products products);
    List<Products> listAll();
}
