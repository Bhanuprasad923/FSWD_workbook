package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDiDemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringDiDemoApplication.class, args);
  }
  
  @Autowired
  private CarConstructor c;
  
  @Override
    public void run(String... args) {
        c.drive();
        
    }

}