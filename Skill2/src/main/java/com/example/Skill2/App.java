package com.example.Skill2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                                        .configure("hibernate.cfg.xml")
                                        .build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();

        // ------------------- INSERT Products -------------------
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setPrice(75000);
        p1.setQuantity(10);
        session.save(p1);

        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setDescription("Wireless Mouse");
        p2.setPrice(1200);
        p2.setQuantity(50);
        session.save(p2);

        Product p3 = new Product();
        p3.setName("Earphones");
        p3.setDescription("Wired Earphones");
        p3.setPrice(200);
        p3.setQuantity(150);
        session.save(p3);

        Product p4 = new Product();
        p4.setName("Headset");
        p4.setDescription("Gaming Headset");
        p4.setPrice(200);
        p4.setQuantity(10);
        session.save(p4);

        tx.commit();
        session.close();
        System.out.println("Insertion successfully completed");

        
        Session session2 = sf.openSession();

        // RETRIEVE Product by ID
        Product product = session2.get(Product.class, 1);
        if (product != null) {
            System.out.println("\nProduct Retrieved by ID:");
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
        }

        // UPDATE Product (Employee-style)
        Transaction tx2 = session2.beginTransaction();
        Product updateProduct = session2.get(Product.class, 3); 
        if (updateProduct != null) {
            updateProduct.setPrice(150);
            updateProduct.setQuantity(300);
            session2.update(updateProduct);
            System.out.println("\nUpdated product details:");
            System.out.println("ID: " + updateProduct.getProductId());
            System.out.println("Name: " + updateProduct.getName());
            System.out.println("Price: " + updateProduct.getPrice());
            System.out.println("Quantity: " + updateProduct.getQuantity());
        }
        tx2.commit();

        // DELETE Product 
        Transaction tx3 = session2.beginTransaction();
        Product deleteProduct = session2.get(Product.class, 2); 
        if (deleteProduct != null) {
            System.out.println("\nProduct discontinued:");
            System.out.println("ID: " + deleteProduct.getProductId());
            System.out.println("Name: " + deleteProduct.getName());
            session2.delete(deleteProduct);
            System.out.println("Product deleted successfully");
        }
        tx3.commit();

        session2.close();
        sf.close();
    }
}
