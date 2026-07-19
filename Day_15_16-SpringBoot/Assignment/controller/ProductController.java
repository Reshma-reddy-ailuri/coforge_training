package com.coforge.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

@RestController
@RequestMapping("/api/v1/pms")
public class ProductController {

	private ProductService service;
	private Environment environment;

	@Autowired
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	// SAVE
	@PostMapping("/products")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.saveProduct(product);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("pms.save.success"),
						HttpStatus.CREATED);
			}

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// UPDATE
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable("pid") int pid,
			@RequestBody Product product) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.updateProduct(pid, product);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("pms.update.success"),
						HttpStatus.OK);
			}

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// DELETE BY ID
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteByPid(@PathVariable("pid") int pid) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.deleteByPid(pid);

			if (status) {
				responseEntity = new ResponseEntity<>(
						environment.getProperty("pms.delete.success"),
						HttpStatus.OK);
			}

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// FIND BY ID
	@GetMapping("/products/{pid}")
	public ResponseEntity<?> findByPid(@PathVariable("pid") int pid) {

		ResponseEntity<?> responseEntity = null;

		try {

			Optional<Product> product = service.findByPid(pid);

			responseEntity = new ResponseEntity<>(
					product.get(),
					HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(
					e.toString(),
					HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// FIND ALL
	@GetMapping("/products")
	public ResponseEntity<?> findAllProducts() {

		try {
			return new ResponseEntity<>(service.findAllProducts(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}
	}

	// FIND BY NAME
	@GetMapping("/products/name/{pname}")
	public ResponseEntity<?> findByPname(@PathVariable("pname") String pname) {

		try {
			return new ResponseEntity<>(service.findByPname(pname), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	// DELETE BY NAME
	@DeleteMapping("/products/name/{pname}")
	public ResponseEntity<?> deleteByPname(@PathVariable("pname") String pname) {

		try {

			service.deleteByPname(pname);

			return new ResponseEntity<>(
					environment.getProperty("pms.delete.success"),
					HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	// FIND BY QUANTITY
	@GetMapping("/products/quantity/{quantity}")
	public ResponseEntity<?> findByQuantity(@PathVariable("quantity") int quantity) {

		try {
			return new ResponseEntity<>(service.findByQuantity(quantity), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	// FIND BY PRICE
	@GetMapping("/products/price/{price}")
	public ResponseEntity<?> findByPrice(@PathVariable("price") double price) {

		try {
			return new ResponseEntity<>(service.findByPrice(price), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	// PRICE RANGE
	@GetMapping("/products/price/{minPrice}/{maxPrice}")
	public ResponseEntity<?> findByPriceBetween(
			@PathVariable double minPrice,
			@PathVariable double maxPrice) {

		try {
			return new ResponseEntity<>(
					service.findByPriceBetween(minPrice, maxPrice),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	// GET PRODUCT IDS
	@GetMapping("/products/pids")
	public ResponseEntity<?> getPidsList() {

		try {
			return new ResponseEntity<>(service.getPidsList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}
	}

	// COUNT & SUM
	@GetMapping("/products/info")
	public ResponseEntity<?> getInfo() {

		try {
			return new ResponseEntity<>(service.getInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}
	}
}