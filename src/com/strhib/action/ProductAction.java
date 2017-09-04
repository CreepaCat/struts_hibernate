package com.strhib.action;


import com.opensymphony.xwork2.ActionContext;
import com.strhib.dao.ProductDAO;
import com.strhib.pojo.Product;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class ProductAction {
    ProductDAO pdao = new ProductDAO();
    Product product;
    List<Product> products;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String add(){
        pdao.add(product);
        return "list";
    }
    public String delete(){
        pdao.delete(product.getId());
        return "list";
    }
    public String update(){
        pdao.update(product);
        return "list";
    }
    public String list(){
       products = pdao.listProduct();
        System.out.println("ProductionAction list():");
        System.out.println(products);
        Map map = ActionContext.getContext().getSession();
        map.put("products",products);
       return "listJSP";
    }
    public String edit(){
        //单条编辑，返回编辑页面
        product = pdao.get(product.getId());
        Map map = ActionContext.getContext().getSession();
        map.put("product",product);
        return "edit";
    }

}
