package com.strhib.dao;

import com.strhib.pojo.Product;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductDAO {
    public void add(Product product){
        List<Product> result = new ArrayList();
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        //开启会话
        Session s = sf.openSession();
        //开启事务
        s.beginTransaction();
        s.save(product);
        //提交事务
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    //用于单条编辑
    public Product get(int id){
      //  List<Product> result = new ArrayList();
        Product result = null;
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
       // s.beginTransaction();
        result = (Product)s.get(Product.class,id);
        s.close();
        sf.close();
        return result;
    }
    public void delete(int id){
        List<Product> result = new ArrayList();
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Product p = (Product)s.get(Product.class,id);
        s.delete(p);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public void update(Product p){
        List<Product> result = new ArrayList();
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
       // result = (Product)s.get(Product.class,id);
        s.update(p);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    public List<Product> listProduct(){
        List<Product> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Product p");

        result = q.list();
        System.out.println("listDAO result:");
        System.out.println(result);

        s.close();
        sf.close();
        return result;

    }
}
