package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.dto.ProductDTO;
import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;
import com.coforge.pms.service.client.SupplierClient;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;
	private Environment environment;
	private SupplierClient supplierClient;

	@Autowired
	public ProductServiceImpl(ProductRepo productRepo, Environment environment, SupplierClient supplierClient) {
		this.productRepo = productRepo;
		this.environment = environment;
		this.supplierClient = supplierClient;
	}

	@Override
	public boolean saveProduct(Product product) {

		productRepo.save(product);
		return true;
	}

	@Override
	public boolean updateProduct(Long productId, Product product) {

		if (!productRepo.existsById(productId)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		product.setPid(productId);
		productRepo.save(product);

		return true;
	}

	@Override
	public boolean deleteProductById(Long productId) {

		if (!productRepo.existsById(productId)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		productRepo.deleteById(productId);

		return true;
	}

	@Override
	public Optional<Product> findByPid(Long productId) {

		if (!productRepo.existsById(productId)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return productRepo.findById(productId);
	}

	@Override
	public List<Product> findAllProducts() {

		return (List<Product>) productRepo.findAll();
	}

	@Override
	public List<Product> findByPname(String pname) {

		List<Product> products = productRepo.findByPname(pname);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname) {

		int count = productRepo.deleteByPname(pname);

		if (count == 0) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return true;
	}

	@Override
	public List<Product> findByQuantity(Integer quantity) {

		List<Product> products = productRepo.findByQuantity(quantity);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}

	@Override
	public List<Product> findByPrice(Double price) {

		List<Product> products = productRepo.findByPrice(price);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}

	@Override
	public List<Product> findByPriceBetween(Double minPrice, Double maxPrice) {

		List<Product> products = productRepo.findByPriceBetween(minPrice, maxPrice);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}

	@Override
	public List<Long> getPidsList() {

		return productRepo.getPidsList();
	}

	@Override
	public String getInfo() {

		return productRepo.getInfo();
	}

	@Override
	public List<Product> findBySupplierId(Long supplierId) {

		List<Product> products = productRepo.findBySupplierId(supplierId);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}
	
	@Override
	public ProductDTO getProductWithSupplier(Long productId) {

		Product product = productRepo.findById(productId).orElseThrow(
				() -> new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound")));
		
		System.out.println(product);
		System.out.println("Supplier Id = " + product.getSupplierId());

		SupplierDTO supplier = supplierClient.getSupplier(product.getSupplierId());

		ProductDTO response = new ProductDTO();

		response.setProductId(product.getPid());
		response.setProductName(product.getPname());
		response.setPrice(product.getPrice());
		response.setQuantity(product.getQuantity());
		response.setSupplier(supplier);

		return response;
	}
}