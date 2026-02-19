package com.klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppController {

	@Autowired
	  Service s;

	@PostMapping("product")
	public String insertProduct(@RequestBody Product product) {
	    return s.insertData(product);
	}


	  @GetMapping("product")
	  public List<Product> retrive() {
	    return s.retrivedata();
	   
	  }
	  
	  @PutMapping("product")
	  public String update(@RequestBody Product product) {
	      return s.updateProduct(product);
	  }

	  @DeleteMapping("product/{id}")
	  public String delete(@PathVariable int id) {
	      return s.deleteProduct(id);
	  }

}

