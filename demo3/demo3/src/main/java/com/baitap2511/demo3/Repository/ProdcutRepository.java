package com.baitap2511.demo3.Repository;

import com.baitap2511.demo3.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Products, Long> {
}
