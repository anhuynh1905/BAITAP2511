package com.baitap2511.demo3.Service;

import com.baitap2511.demo3.Repository.ProdcutRepository;
import com.baitap2511.demo3.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdcutServiceImpl implements ProdcutServices{
    @Autowired
    private ProdcutRepository repo;

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Products get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Products save(Products products) {
        return repo.save(products);
    }

    @Override
    public List<Products> listAll() {
        return repo.findAll();
    }
}
