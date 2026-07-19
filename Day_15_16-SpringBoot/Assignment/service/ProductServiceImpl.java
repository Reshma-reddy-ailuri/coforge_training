package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;

	@Autowired
	public ProductServiceImpl(ProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveProduct(Product product) throws InvalidProductObjectException {

		if (product != null &&
			product.getPid() > 0 &&
			product.getPname() != null &&
			product.getPrice() > 0 &&
			product.getQuantity() > 0) {

			repo.save(product);
			return true;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public boolean updateProduct(int pid, Product product)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pid > 0 &&
			product != null &&
			product.getPid() > 0 &&
			product.getPname() != null &&
			product.getPrice() > 0 &&
			product.getQuantity() > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			repo.save(product);
			return true;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public boolean deleteByPid(int pid)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pid > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			repo.deleteById(pid);
			return true;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public Optional<Product> findByPid(int pid)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pid > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			return repo.findById(pid);
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>) repo.findAll();
	}

	@Override
	public List<Product> findByPname(String pname)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pname != null) {

			List<Product> products = repo.findByPname(pname);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pname != null) {

			int n = repo.deleteByPname(pname);

			if (n == 0) {
				throw new ProductNotFoundException();
			}

			return true;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public List<Product> findByQuantity(int quantity)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (quantity > 0) {

			List<Product> products = repo.findByQuantity(quantity);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public List<Product> findByPrice(double price)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (price > 0) {

			List<Product> products = repo.findByPrice(price);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public List<Product> findByPriceBetween(double minPrice, double maxPrice)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (minPrice > 0 && maxPrice > 0) {

			List<Product> products = repo.findByPriceBetween(minPrice, maxPrice);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}
		else {
			throw new InvalidProductObjectException();
		}
	}

	@Override
	public List<Integer> getPidsList() {
		return repo.getPids();
	}

	@Override
	public Object[] getInfo() {
		return repo.getInfo();
	}
}