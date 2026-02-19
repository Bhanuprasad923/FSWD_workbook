package com.klu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("Demo1")
	public int fun1() {
		return 10;
		
	}
	@GetMapping("Demo2")
		public String fun2()
		{
		return "Welcome to KL University";
		}

	@GetMapping("/demo3/{a}/{b}")
	public int fun3(@PathVariable("a")int a ,@PathVariable("b")int b)
	{
		return a+b;
	}
	
}
