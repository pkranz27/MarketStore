package com.tts.Market.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.Market.Model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
	Product findById(long id);
	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String category);
	List<Product> findByBrandAndCategory(String brand, String category);
	
	@Query("SELECT DISTINCT p.brand FROM Product p")
	List<String> findDistinctBrands();
	@Query("SELECT DISTINCT p.category FROM Product p")
	List<String>findDistinctCategories();

}
