package com.example.Hibernate_CURD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        //insert
       /* Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("hari");
        s.save(e1);
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("kiran");
        s.save(e2);
        t.commit();
        s.close();*/
        
       /* Employee e = new Employee();
        e.setId(1510);
        e.setName("harry");
        s.update(e);
        Employee e1 =new Employee();
        e1.setId(1512);
        e1.setName("potter");
        s.delete(e1);
        
        t.commit();
        s.close();*/
        
        List<Employee> al = s.createQuery("from Employee",Employee.class).list();
        
        for(Employee e : al)
        {
        	System.out.println(e.getId()+" " + e.getName());
        }
        
        
        System.out.println("Insert Sucess");
        
        
    }
}
