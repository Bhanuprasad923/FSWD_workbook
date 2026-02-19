package com.klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	Repo r;

	  public String insertData(Product product) {
	    r.save(product);
	    return "Data saved success";
	  }

	  public List<Product> retrivedata() {
	    return r.findAll();
	  }
	  public String updateProduct(Product product) {
		    if (r.existsById(product.getId())) {
		        r.save(product);
		        return "Product updated successfully";
		    }
		    return "Product not found";
		}

		public String deleteProduct(int id) {
		    if (r.existsById(id)) {
		        r.deleteById(id);
		        return "Product deleted successfully";
		    }
		    return "Product not found";
		}
}
