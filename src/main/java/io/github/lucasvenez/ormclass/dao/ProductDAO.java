package io.github.lucasvenez.ormclass.dao;

import io.github.lucasvenez.ormclass.model.Product;

import java.util.List;

public class ProductDAO extends DAO<Product> {

	public Product getById(final Long id) {
        return entityManager.find(Product.class, id);
    }
 
    public boolean removeById(final Long id) {
    	
    	boolean result = true;
    	
        try {
            Product product = getById(id);
            remove(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        
        return result;
    }
 
    @SuppressWarnings("unchecked")
	public List<Product> findAll() {
    	return entityManager
    		.createQuery("FROM Product").getResultList();
    }
}
